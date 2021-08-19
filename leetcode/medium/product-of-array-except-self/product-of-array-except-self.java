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