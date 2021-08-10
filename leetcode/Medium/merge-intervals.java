import java.util.*;

class Solution {
  public int[][] merge(int[][] intervals) {

    List<int[]> res = new ArrayList<>();
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    for (int i = 0; i < intervals.length; i++) {
      if (intervals.length - 1 == i) {
        res.add(intervals[i]);
        break;
      }
      if (intervals[i][1] >= intervals[i + 1][0]) {
        intervals[i + 1][0] = intervals[i][0];
        if (intervals[i][1] > intervals[i + 1][1])
          intervals[i + 1][1] = intervals[i][1];
      } else {
        res.add(intervals[i]);
      }
    }
    return res.toArray(new int[res.size()][]);
  }
}