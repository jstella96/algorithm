# Employee Free Time

## 문제 설명

> We are given a list `schedule` of employees, which represents the working time for each employee.
> Each employee has a list of non-overlapping `Intervals`, and these intervals are in sorted order.
> Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

직원 개개인의 근무 시간을 나타내는 이중배열 `schedule`이 주어집니다.
각 직원마다 겹치지 않는 `Intervals`이 주어지며 `Intervals`은 정렬되어 있습니다.  
모든 직원이 휴식시간(free-time)인 시간간격을 정렬하여 반환합니다.  
**주의:** 내부의 객체는 배열이 아닌 Intervals입니다. 즉, `schedule[0][0].start = 1`, `schedule[0][0].end = 2`로 표현됩니다. 또한 [5, 5]와 같은 간격은 길이가 0이므로 답변에 포함하지 않습니다.

## 문제 풀이

1. 모든 직원들이 공통으로 쉬는 휴식시간을 구하는 것이기에 주어진 어떠한 interval에도 포함되지 않는 시간 간격을 구하면 된다.
2. 먼저 모든 interval을 list에 넣고, 시작시간으로 정렬한다.

이후 interval의 start가 lastTime보다 작다면 이전에 행한 work 가 끝나기 전에 해당 index의 작업이 시작되었다는 것입니다.

1. index 와 lastend변수를 선언합니다
2. index <len
3. while문안에서 Max.math

## 풀이 코드

```java
/*
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
/*가장시간이 빠른거 부터 시작 -> 그러나 그런 조건x*//*
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
    int currentTime = allInterval.get(index).start;
    PriorityQueue<Interval> pq = new PriorityQueue<>((i1, i2) -> i2.end - i1.end);

    while ( index < len) {
      System.out.println("indx ; "+currentTime);
        // 현재 진행 중인 작업의 끝나는 시점전에 들어온 요청을 PriorityQueue에 넣는다.
      while (index < len && allInterval.get(index).start <= currentTime) {
          System.out.println(allInterval.get(index).start);
        pq.add(allInterval.get(index));
        index++;
      }
      //System.out.println(pq.size());
        // 한 작업이 끝날때까지 새로 들어온 요청이 없을 때
      if (pq.isEmpty()) {

        Interval interval = allInterval.get(index);
        result.add(new Interval(currentTime, interval.start));
        currentTime = interval.start;
        // 한 작업이 끝날때 새로 들어온 요청이 있을 때 가장 늦게끝나는거 실행하며, queue 제거
      } else {
        Interval interval = pq.poll();
        if(interval.end > currentTime){
            currentTime = interval.end;
        }
        pq.clear();
      }

    }
    return result;
  }
}
```

/_ 다른 풀이_/
이후 interval의 start가 lastTime보다 작다면 이전에 행한 work 가 끝나기 전에 해당 index의 작업이 시작되었다는 것입니다.

1. index 와 lastend변수를 선언합니다
2. index <len
3. while문안에서 Max.math

Math.max(lastWorkTime)

```java
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

<또 다른 풀이>

스택을 쓰면 greedy로 쉽게 풀림???
