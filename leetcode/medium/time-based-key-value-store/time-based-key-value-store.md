# time-based-key-value-store
[문제링크](https://leetcode.com/problems/time-based-key-value-store/)

## 문제 설명

다른 타임스탬프에서 동일한 키에 대한 여러 값을 저장하고 특정 타임스탬프에서 키 값을 검색할 수 있는 시간 기반 키-값 데이터 구조를 설계합니다.

- TimeMap(): 데이터 구조를 초기화합니다.
- void set(String key, String value, int timestamp): 주어진 타임스탬프에서 값과 키를 저장합니다.
- String get(String key, int timestamp) : timestamp_prev <= timestamp 인 set이 이전에 호출된 값을 반환합니다. 이러한 값이 여러 개인 경우 가장 큰 timestamp_prev와 관련된 값을 반환합니다. 값이 없으면 ""를 반환합니다.

## 문제 풀이

binary search를 이용해준다.  
주의점은 일치 값을 찾지 못했을경우 인접한 가장 큰 값을 반환해주기 때문에  
binary search 진행중 min 값이 바뀌기 전에 인접한 값들에 답이 있는지 확인해보는  
코드 추가와 몇 가지의 예외처리가 필요하다.  
**[예외처리]**  
list갯수가 1일 경우와 마지막 리스트값이 비교 타임존보다 작을경우

## 풀이 코드

```java
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

//1]객체 만듬
class TimeDet {
  int ts;
  String value;

  public TimeDet(int ts, String value) {
    this.ts = ts;
    this.value = value;
  }
}

class TimeMap {
  //2] 들어온 값을 담을 map 선언
  private HashMap<String, List<TimeDet>> map;

  //3] TimeMap() 은 초기화 작업만
  public TimeMap() {
    this.map = new HashMap<>();
  }
  //4] set()은 존재 유무 따져서 list에 add()
  public void set(String key, String value, int timestamp) {
    if (!map.containsKey(key)) {
      map.put(key, new ArrayList<>());
    }
    map.get(key).add(new TimeDet(timestamp, value));
  }
  //5] get()
  public String get(String key, int timestamp) {
     //없으면 return
    if (!map.containsKey(key))
      return "";

    //있다면, value 값에서 해당 ts or 가장가까운 ts 찾아야한다.
    List<TimeDet> list = map.get(key);

    //예외처리 list갯수가 1일 경우와  마지막 리스트값이 비교 타임존보다 작을경우 + 속도면에서도 좋음
    int listSize = list.size();
    if (list.size() == 1)
      return list.get(0).value;
    if (list.get(listSize - 1).ts < timestamp)
      return list.get(listSize - 1).value;

    //b.s이용시작.
    int low = 0;
    int high = list.size() - 1;

    while (low <= high) { // [(ts1,value1),(ts2,value2),(ts3,value3).....] 들어온 ts 같거나 가장 큰 값
      int mid = (low + high)/ 2;
      TimeDet midObj = list.get(mid);

      if (midObj.ts == timestamp) {
        return midObj.value;
      }
      if (midObj.ts < timestamp) {
        //오른쪽 값 크기 비교 후  사이 구간인지 그걸 판단.
        // mid.ts (i) <   ts  < rigth.ts(i+1)
        int rightSide = mid + 1 > list.size() - 1 ? list.size() - 1 : mid + 1;
        if (list.get(rightSide).ts > timestamp) {
          return midObj.value;
        }
        low = mid + 1;
      } else if (midObj.ts > timestamp) {
        //왼쪽 값 크기 비교 후 사이 구간인지 그걸 판단.
        // left.ts (i) <   ts  < mid.ts (i+1)
        int leftSide = mid == 0 ? 0 : mid - 1;
        if (list.get(leftSide).ts < timestamp) {
          return list.get(leftSide).value;
        }
        high = mid - 1;
      }
    }
    return "";
  }
}
```
