# find-median-from-data-stream

[문제링크](https://leetcode.com/problems/employee-free-time/)

## 문제 설명

직원 개개인의 근무 시간을 나타내는 이중배열 `schedule`이 주어집니다.
각 직원마다 겹치지 않는 `Intervals`이 주어지며 `Intervals`은 정렬되어 있습니다.  
모든 직원이 휴식시간(free-time)인 시간간격을 정렬하여 반환합니다.  
**주의:** 내부의 객체는 배열이 아닌 Intervals입니다. 즉, `schedule[0][0].start = 1`, `schedule[0][0].end = 2`로 표현됩니다. 또한 [5, 5]와 같은 간격은 길이가 0이므로 답변에 포함하지 않습니다.
## 문제 풀이

모든 직원들이 공통으로 쉬는 휴식시간을 구하는 것이기에 주어진 어떠한 interval에도 포함되지 않는 시간 간격을 구하면 됩니다.

1. 먼저 모든 interval을 list에 넣고, 시작시간으로 정렬합니다.

2. 이후 interval의 start가 lastTime보다 작다면 이전에 행한 work 가 끝나기 전에 해당 index의 작업이 시작되었다는 것입니다.

3. lastWorkTime 이란 변수를 선언합니다 이 변수는 현재까지의 작업들 중에 가장 큰 endTime을 기록하는 변수입니다.
   lastWorkTime의 시작값은 list[0].startTime입니다.
  
4. list에 들어간 interval을 순차적으로 체크합니다.


**체크하는 과정에는 아래와 같은 로직이 실행됩니다.**

interval의 startTime이 lastWorkTime보다 작다면 이전에 행한 work 가 끝나기 전에 해당 index의 작업이 시작되었다는 것입니다. 즉 작업시간이 겹쳐있다는 것을 의미합니다. 이 부분을 while문을 통해 표현할 수 있습니다.
만약 `interval.startTime < lastWorkTime`
이라면 index +1 을 하여 다음 interval로 넘어가고 `lastWorkTime = Math.max(lastWorkTime,interval.endTime)`을 통해 현재 작업한 interval중 가장 끝 종료시간을 구합니다.

이 while 문을 빠져 나왔다는 것은 다음 interval.startTime이 이전까지의 작업들 중 가장 끝에 있는 종료시각보다 더 크다는 것을 의미합니다(=lastWorkTime). 즉 [lastWorkTime, interval.startTime] 우리가 찾는 작업자들의 휴식시간입니다. 이 값을 반환값 기록해두고 lastWorkTime값에 interval.startTime을 넣어주어 다음 반복문이 실행 될 수 있게 합니다.

## 풀이 코드

```java
/*lastWorkTime = allInterval.get(index).end
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/
class Solution {
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

    List<Interval> result = new ArrayList<>();
    List<Interval> allInterval = new ArrayList<>();

    for (List<Interval> list : schedule) {
      allInterval.addAll(list); // 모르던 함수
    }
    // 시작시간 오름차순 정렬
    Collections.sort(allInterval, new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return o1.start - o2.start;
      }
    });

    int len = allInterval.size();
    int index = 0;

    int lastWorkTime = allInterval.get(index).start;
    while ( index < len) {
       // 현재 진행 중인 작업의 끝나는 시점전에 들어온 요청순회
      while (index < len && allInterval.get(index).start <= lastWorkTime) {
				lastWorkTime = Math.max(lastWorkTime,allInterval.get(index).end);
        index++;
      }
			if(index == len) break;
      Interval interval = allInterval.get(index);
      result.add(new Interval(lastWorkTime, interval.start));
      lastWorkTime = interval.end;
    }
    return result;
  }
}
```
