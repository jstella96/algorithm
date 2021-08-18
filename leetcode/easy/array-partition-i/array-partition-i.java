/*
	[풀이과정]
		문제 힌트에 보면 규칙을 찾으라고 되어 있다. 
		예시로 주어진 문제들에서 규칙성을 찾아보면 숫자들을 정렬 했을 때 0 ,2 ,4.. 번째 숫자들의 합이 
		최대값이 된다. 
*/

import java.util.Arrays;

class Solution {
  public int arrayPairSum(int[] nums) {
    Arrays.sort(nums);
    int sum = 0;
    for (int i = 0; i < nums.length; i += 2) {
      sum += nums[i];
    }
    return sum;
  }
}