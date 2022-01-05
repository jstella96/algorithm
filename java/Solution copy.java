import java.util.*;

class Interval {
  public int start;
  public int end;

  public Interval() {
  }

  public Interval(int _start, int _end) {
    start = _start;
    end = _end;
  }
};

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
    int count = 0;
    int currentTime = 0;
    int index = 0;
    PriorityQueue<Interval> pq = new PriorityQueue<>((i1, i2) -> i2.end - i1.end);

    while (count < len) {
      // 한 작업이 끝날때까지 새로 들어온 요청이 없을 때
      if (pq.isEmpty()) {
        Interval interval = allInterval.get(index);
        result.add(new Interval(currentTime, interval.start));
        currentTime = interval.start;
        // 한 작업이 끝날때 새로 들어온 요청이 있을 때 가장 늦게끝나는거 실행하며, queue 제거
      } else {
        Interval interval = pq.poll();
        pq.clear();
        currentTime += interval.end;
        count = count + pq.size();
      }
      // 현재 진행 중인 작업의 끝나는 시점전에 들어온 요청을 PriorityQueue에 넣는다.
      while (index < len && allInterval.get(index).start <= currentTime) {
        pq.add(allInterval.get(index));
        index++;
      }
    }
    return result;
  }
}