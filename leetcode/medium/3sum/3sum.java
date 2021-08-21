
/*
[풀이과정]
앞측으로 이동하면서 투포인터 사용. 
예외처리도 까다롭다. 
*/
import java.util.*;

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums); // 중복값처리 때문에 필요하다.
    int len = nums.length;
    List<List<Integer>> answer = new ArrayList<List<Integer>>();

    for (int i = 0; i < len; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) // 중복값처리
        continue;
      int leftPoint = i + 1;
      int rightPoint = len - 1;
      while (leftPoint < rightPoint) { // 포인터가 스치는 순간 까지
        int sum = nums[i] + nums[leftPoint] + nums[rightPoint];
        if (sum < 0) {
          leftPoint++;
        } else if (sum > 0) {
          rightPoint--;
        } else {
          List<Integer> sums = new ArrayList<Integer>();
          sums.add(nums[i]);
          sums.add(nums[leftPoint]);
          sums.add(nums[rightPoint]);

          answer.add(sums);

          while (leftPoint < rightPoint && nums[leftPoint] == nums[leftPoint + 1]) {
            leftPoint++;
          }
          while (leftPoint < rightPoint && nums[rightPoint] == nums[rightPoint - 1]) {
            rightPoint--;
          }
          leftPoint++;
          rightPoint--;
        }
      }
    }
    return answer;
  }
}