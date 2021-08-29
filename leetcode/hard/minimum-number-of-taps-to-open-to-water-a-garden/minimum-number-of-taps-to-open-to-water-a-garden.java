class Solution {
  public int minTaps(int n, int[] ranges) {
    int[] intervals = new int[n + 1];
    Arrays.fill(intervals, -1);
    // intervals 각 포인트가 가질 수 있는 최대 값으로 셋팅.
    // index 지점에서 어디까지 rightPoint 를 찍을 수 있는 지
    for (int i = 0; i < ranges.length; i++) {
      int left = Math.max(0, i - ranges[i]);
      int right = Math.min(n, i + ranges[i]);
      intervals[left] = right;
    }

    int current = 0;
    int maxR = 0;
    int count = 0;
    // 0부터 현재 indexPoint 지점
    for (int i = 0; i <= n; i++) {
      if (maxR < i)
        return -1;
      // 교차점 지나갈 때
      if (current < i) {
        // 차이가 생겼을 때 업데이트
        current = maxR;
        // 카운팅
        count++;
      }
      // 1]현재 포인트에서 갈 수 있는 최대.
      maxR = Math.max(maxR, intervals[i]);
    }
    return count;
  }
}