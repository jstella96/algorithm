/* 
	[풀이 과정]
		for문으로 주어진 값을 PriorityQueue 셋팅 후 while문으로 2개의 최소 값을 꺼내고, 
		계산하여 다시 PriorityQueue에 add 함  while문이후에 바로 if 문으로 예외처리를 하는데 
		그 때 적절한 조건 주기
	[수정]
		첫 번째 풀이 로직은 비슷했으나 정확도에서 4개 런타임초과
		-> if문을 간단하게 수정하니 통과.
		
*/
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int answer = 0;
        for( int aScoville : scoville){
            priorityQueue.offer(aScoville);
        }
        while(priorityQueue.peek() < K){
            if(priorityQueue.size() == 1 ) return -1;
            answer++;
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            int newSocvile = first + ( second * 2 );
            priorityQueue.offer(newSocvile);
        }
        return answer;
    }
}