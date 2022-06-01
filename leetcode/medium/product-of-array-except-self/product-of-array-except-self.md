# product-of-array-except-self


[문제링크](https://leetcode.com/problems/product-of-array-except-self/)

## 문제 설명

정수 배열 `nums`가 주어지면 answer[i]가 nums[i]를 제외한 `nums`의 모든 요소의 곱과 같도록 배열 응답을 반환합니다.
나누기 연산을 사용하지 않고 O(n) 시간에 실행되는 알고리즘을 작성해야 합니다.

## 입출력 예시

```
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
```

## 문제 풀이

투 포인터 문제! 왼쪽 오른쪽으로 곱한값을 곱해주면 된다.

## 풀이 코드

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int[] answer = new int[len];
        int leftPoint = 1;
        int rightPoint = 1;

        for(int i = 0 ; i < len ; i++){
            answer[i] =  leftPoint;
            leftPoint *= nums[i];
        }

        for(int z = len-1 ; z > -1 ; z--){
            answer[z] = answer[z] * rightPoint;
            rightPoint *= nums[z];
        }

        return answer;
    }
}
```

풀이2
```java
/*
 [풀이과정]
	자신을 제외한 배열의 곱을 구한다고 생각하고 만나는 에러처리 다 해주며 풀었다
	-> 좀 더 직관적인 방법의 풀이 알아보기 
*/
class Solution {
  public int[] productExceptSelf(int[] nums) {
    // 1]
    int product = 0;
    int zeroCheck = 0;
    for (int num : nums) {
      if (num == 0) {
        zeroCheck++;
      } else {
        if (product == 0)
          product = 1;
        product *= num;
      }

    }
    // 2]
    int len = nums.length;
    int[] answer = new int[len];
    for (int i = 0; i < len; i++) {
      if (zeroCheck >= 2) {
        answer[i] = 0;
      } else if (zeroCheck >= 1) {
        answer[i] = (nums[i] == 0) ? product : 0;
      } else {
        answer[i] = product / nums[i];
      }
    }
    return answer;
  }
}
```
