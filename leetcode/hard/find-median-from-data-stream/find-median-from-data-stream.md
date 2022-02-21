# find-median-from-data-stream

## 풀이 과정

1. 힙을 2개둬서 min, max로 푼다.
2. 바이너리서치

## 풀이 코드

1.

```
/*
	[풀이 과정]
		왔다갔다하는게 포인트
	[수정]

*/
//내 풀이
import java.util.*;

class MedianFinder {
    private PriorityQueue<Integer> maxHeap; //상단 노드 높은 값

    private PriorityQueue<Integer> minHeap; //상단 노드 작은 값

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        //min이 기준이면 포인트는 한번씩 번갈아 가면됨.!
        if(maxHeap.size() == minHeap.size()){
           maxHeap.offer(num);
           minHeap.offer(maxHeap.poll());
        }else{
           minHeap.offer(num);
           maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        double answer = 0;
        if(maxHeap.size() == minHeap.size()) {
            answer = ((double)(maxHeap.peek() + minHeap.peek()) / 2);
        }else{
            answer = minHeap.peek();
        }
        return answer;
    }
}
```
