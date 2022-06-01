# maximum-subarray

[문제링크](https://leetcode.com/problems/maximum-subarray/)

## 문제 설명

정수 배열 `nums`가 주어지면 가장 큰 합을 갖는 연속 subarray(최소한 하나의 숫자 포함)을 찾아 합을 반환합니다. subarray은 배열의 연속적인 부분입니다.

## 입출력 예시

```
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

## 문제 풀이

앞에서 부터 더하다가 현재 인덱스가 앞선 값보다 크면 currentSum 값 업데이트  
currentSum 정의 : 현재 자리를 포함하는 최대 subarray이다. 이 정의에서 만들어 졌으니 정답이 있을 수 밖에 없다.

## 풀이 코드

```java
class Solution {
    public int maxSubArray(int[] nums) {

    	int currentSum = nums[0];
    	int maxSum = nums[0];

    	for(int i=1; i<nums.length; i++) {
    		currentSum = Math.max(nums[i]+currentSum, nums[i]);
    		maxSum = Math.max(currentSum, maxSum);
    	}

    	return maxSum;

    }
}
```
