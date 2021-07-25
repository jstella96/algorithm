
/* 
	[풀이 과정]
		binary search를 이용해준다.
    주의점은 일치 값을 찾지 못했을경우 인접한 가장 큰 값을 반환해주기 때문에 
    binary search 진행중 min 값이 바뀌기 전에 인접한 값들에 답이 있는지 확인해보는 
    코드 추가와 몇 가지의 예외처리가 필요하다. 
	[예외처리]
    list갯수가 1일 경우와 
    마지막 리스트값이 비교 타임존보다 작을경우
  [수정]
    마지막 return은 필요없다. 논리적으로 사용되지 않을 코드 -> 수정 여지가 남아있다.
		binary search 진행중 min 값이 바뀌기 전에 인접한 값들에 답이 있는지 확인해보는 코드를 
    더 readibility 하게 만들 수 있는 방법, 더 효율성 있는 코드를 만들 방법이 있을 것이다. 
*/
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class TimeDet {
  int ts;
  String value;

  public TimeDet(int ts, String value) {
    this.ts = ts;
    this.value = value;
  }
}

class TimeMap {

  private ConcurrentHashMap<String, List<TimeDet>> map;

  /** Initialize your data structure here. */
  public TimeMap() {
    this.map = new ConcurrentHashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if (!map.containsKey(key)) {
      map.put(key, new ArrayList<>());
    }
    map.get(key).add(new TimeDet(timestamp, value));
  }

  public String get(String key, int timestamp) {
    if (!map.containsKey(key))
      return "";
    List<TimeDet> list = map.get(key);
    int low = 0;
    int high = list.size() - 1;
    while (low <= high) { // [(ts1,value1),(ts2,value2),(ts3,value3).....] 들어온 ts 같거나 가장 큰 값
      int mid = low + (high - low) / 2;
      TimeDet midObj = list.get(mid);

      if (midObj.ts == timestamp) {
        return midObj.value;
      }
      if (midObj.ts < timestamp) {
        int rightSide = mid + 1 > list.size() - 1 ? list.size() - 1 : mid + 1;
        if (list.get(rightSide).ts > timestamp) {
          return midObj.value;
        }
        low = mid + 1;
      } else if (midObj.ts > timestamp) {
        int leftSide = mid == 0 ? 0 : mid - 1;
        if (list.get(leftSide).ts < timestamp) {
          return list.get(leftSide).value;
        }
        high = mid - 1;
      }
    }

    // [예외처리] 이걸 내리는것만 으로도 속도 감소
    int listSize = list.size();
    if (list.size() == 1)
      return list.get(0).value;
    if (list.get(listSize - 1).ts < timestamp)
      return list.get(listSize - 1).value;

    return ""; // 이 부분은 올 필요가 없다.!!!
  }
}
