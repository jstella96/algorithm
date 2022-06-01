# Delete and Earn

[문제링크](https://leetcode.com/problems/delete-and-earn/)

## 문제 설명

정수 배열 `nums`가 제공됩니다. 다음 작업을 여러 번 수행하여 얻을 수 있는 포인트 수를 최대화하려고 합니다.  
**nums[i]를 선택하고 삭제하면 nums[i] 포인트를 얻을 수 있습니다. 그런 다음 nums[i] - 1과 같은 모든 요소와 nums[i] + 1과 같은 모든 요소를 ​​삭제해야 합니다.**
위의 연산을 몇 번 적용하여 얻을 수 있는 최대 점수를 반환합니다.

## 입출력 예시

```
Input: nums = [3,4,2]
Output: 6
Explanation:
  - 만약 4를 선택한다면 3과2의 값을 가진 모든 요소를 삭제해야한다. 남는건 [2]이므로 총 얻을 수 있는 점수는 6점이다.
  - 만약 3를 선택한다면 2과 4의 값을 가진 모든 요소를 삭제해야 하므로 남는게 없고 얻을 수 있는 점수는 3점 뿐이다.
  - 2를 선택한다 해도 4를 선택했을 때와 같은 값이 나온다.

  즉 답은 최대점수인 6이 된다.
```

## 문제 풀이

dp를 이용해서 풀 수 있다. 가능한 범위를 길이로 가진 배열을 선언한 후에, 정수n이 나올때마다 array[n]에 해당 n값을 더해준다.  
그렇게 된다면 특정 숫자 n을 선택했을 때 그 숫자로 인해 얻을 수 있는 점수는 array[n]이 된다.  
그 후 `dp[i] = Math.max(dp[i - 1], dp[i] + dp[i - 2])`이 dp식을 사용해서 해당 0부터 해당 index에서 얻을 수 있는 최대 값을 dp에 저장한다.

## 풀이 코드

```java
class Solution {
    public int deleteAndEarn(int[] nums) {

        int RANGE = 10000;
        int[] dp = new int[RANGE + 1];
        for(int n : nums)dp[n] += n;

        // [2,2 3,3,3,4] -> [0,0,4,9,4] 여기까지 이해.
        int max = dp[1];
        for(int i = 2; i < RANGE + 1; i ++) {
            dp[i] = Math.max(dp[i - 1], dp[i] + dp[i - 2]);
            if(dp[i] > max)max = dp[i];
        }

        return max;
    }
}


```
