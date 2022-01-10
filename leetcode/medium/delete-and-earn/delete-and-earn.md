# Delete and Earn

## 풀이 과정

```java
class Solution {
    public int deleteAndEarn(int[] nums) {

        int RANGE = 10000;
        int[] dp = new int[RANGE + 1];
        for(int n : nums)dp[n] += n;

        //index 0 house is not used, -> 0
        //index 1 is just the value in dp[1]
        //0숫자는 없으니..
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
