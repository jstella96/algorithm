
/*
  [풀이 과정]
    max와 min  PriorityQueue 를 선언하며, 값 추가시 양 queue에 값을 넣으며 count를 센다
    최대값이 필요할 땐, max에서 최소값이 필요할땐 min에서 값을 뺀다.
    count 가 0만 아니면 위 방법은 올바른 값을 리턴한다. 
  [예외 처리]
    count 값이 0일 때 예외처리를 해준다. 
*/
import java.util.*;

class Solution {
  public int[] solution(String[] operations) {
    // int[] answer = new int[2];
    int[] answer = { 0, 0 };
    int count = 0;
    PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();
    for (String str : operations) {
      String[] array = str.split(" ");
      int num = Integer.parseInt(array[1]);
      if (array[0].equals("I")) {
        count++;
        maxPriorityQueue.offer(num);
        minPriorityQueue.offer(num);

      } else {
        count--;
        if (count <= 0) {// 예외처리
          count = 0;
          maxPriorityQueue.clear();
          minPriorityQueue.clear();
        } else {
          if (num == 1) {
            maxPriorityQueue.poll();
          } else {
            minPriorityQueue.poll();
          }
        }
      }
    }
    if (count != 0) {
      answer[0] = maxPriorityQueue.poll();
      answer[1] = minPriorityQueue.poll();
    }

    return answer;
  }
}