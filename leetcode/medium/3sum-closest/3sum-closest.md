# 3sum-closest

[문제링크](https://leetcode.com/problems/3sum-closest/)

## 문제 설명

길이가 n인 정수 배열 `nums`와 정수 `target`이 주어지면 합계가 `target`에 가장 가깝도록 nums에서 세 개의 정수를 찾아서 반환합니다. 각 입력에 정확히 하나의 솔루션이 있다고 가정할 수 있습니다.

## 입출력 예시

```
Input: nums = [-1,2,1,-4], target = 1
Output: 2
목표에 가장 가까운 합은 2입니다. (-1 + 2 + 1 = 2).
```

## 문제 풀이

array를 전체 정렬한 후 양 끝 포인트에서 상황에 맞게 포인터를 움직이면서 가장 답에 근접한 값을 찾는다.
모든 array을 순회하며, 대상을 무조건 포함한다고 가정한다.

## 풀이 코드

```java
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int result = num[0] + num[1] + num[2];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
```
