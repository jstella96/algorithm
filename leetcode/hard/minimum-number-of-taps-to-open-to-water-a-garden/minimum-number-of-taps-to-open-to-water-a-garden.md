#

## 문제

x축에는 1차원 정원이 있습니다. 정원은 0 지점에서 시작하여 n 지점에서 끝납니다(즉, 정원의 길이는 n입니다).

정원의 [0, 1, ..., n] 지점에 n + 1개의 수도꼭지가 있습니다.

정수 `n`과 길이가 n+1인 배열 `ranges`가 주어집니다, 여기서 `ranges[i](0-indexed)`는 i번째 탭이 열린 경우 영역 [ `i - ranges[i]`, `i + ranges[i]` ]에 물을 줄 수 있음을 의미합니다.

정원 전체에 물을 줄 수 있도록 열려 있어야 할 최소 수도꼭지 개수를 반환하고, 정원에 물을 줄 수 없는 경우 -1개를 반환하십시오.

## 예시

```
Example 1:
Input: n = 5, ranges = [3,4,1,1,0,0]
Output: 1
Explanation: The tap at point 0 can cover the interval [-3,3]
The tap at point 1 can cover the interval [-3,5]
The tap at point 2 can cover the interval [1,3]
The tap at point 3 can cover the interval [2,4]
The tap at point 4 can cover the interval [4,4]
The tap at point 5 can cover the interval [5,5]
Opening Only the second tap will water the whole garden [0,5]
```

```
Example 2:

Input: n = 3, ranges = [0,0,0,0]
Output: -1
Explanation: Even if you activate all the four taps you cannot water the whole garden.
```

## 문제 설명

```java
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
```
