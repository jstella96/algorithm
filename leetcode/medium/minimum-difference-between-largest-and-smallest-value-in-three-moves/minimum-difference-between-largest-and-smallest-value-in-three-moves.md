### 문제 풀이

기본조건 : 정렬 -> 차이 값을 찾는데 순서는 안중요함
정렬 된 상태로 가운데 값을 바꾸는건 minimum difference 걊을 찾는데 의미가 없다.
최대 3개의 값을 바꿀 수 있다면 앞뒤 값을 바꿔보면 된다.

```java
class Solution {
    public int minDifference(int[] nums) {

        if(nums.length <= 4)
            return 0;

        Arrays.sort(nums);

        int interval = nums.length - 4 ;
        int min = Integer.MAX_VALUE;

        for (int i=0; i < 4; i++) {
            min = Math.min(min, nums[i+interval] - nums[i]);
        }
        return min;
    }
}
```
