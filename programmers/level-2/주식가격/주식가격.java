class Solution {
  public int[] solution(int[] prices) {
    int[] answer = new int[prices.length];
    for (int i = 0; i < prices.length; i++) { // 받은 가격들을 순회 n!형태로 풀었다
      for (int z = i; z < prices.length; z++) { // n -> n-1 - > n-2..... 0
        answer[i] = z - i; // 현재 초 입력
        if (prices[z] < prices[i])
          break; // 주식가격이 내려가면 break;
      }
    }
    return answer;
  }
}