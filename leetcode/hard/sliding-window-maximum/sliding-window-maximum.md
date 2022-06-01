# sliding-window-maximum

[문제링크](https://leetcode.com/problems/sliding-window-maximum/)

## 문제 설명

정수 배열이 주어지고 배열의 맨 왼쪽에서 맨 오른쪽으로 이동하는 크기 k의 슬라이딩 창이 있습니다. 창에서는 k개의 숫자만 볼 수 있습니다. 슬라이딩 창이 오른쪽으로 한 위치씩 이동할 때마다. 최대 슬라이딩 윈도우를 반환합니다.

## 풀이 코드

```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();  // stores *indices*
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();  // 이전 값이 이후 값보다 작으면 무시 계산필요 없는 값.
                //자연스럽게 왼쪽 값이 max 값이 된다.
            }
            q.addLast(i); // update
            // remove first element if it's outside the window
            if (q.getFirst() == i - k) { //덱 앞에 윈도우 벗어 난 값 제거
                q.removeFirst();
            }
            if (i >= k - 1) { //앞에 생략 부분 무시
                res.add(nums[q.peek()]);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}
```
