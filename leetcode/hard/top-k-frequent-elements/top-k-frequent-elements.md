# Top K Frequent Elements

## 풀이 과정

## 풀이 코드

```java
/*
풀이방법
map에 1차 계산 후 정렬방식을 map.get(k) 로 바꿔서 정렬 후 뺀다.
*/
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int[] answer = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1) );
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(int key : map.keySet()){
          maxPriorityQueue.offer( key );
        }

        for(int i = 0 ; i < k ; i++){
            answer[i] = maxPriorityQueue.poll();
        }
        return answer;
    }
}
```

이전풀이

```java
/**/import java.util.*;
class Count{
    int num;
    int count;

    Count(int num, int count)
    {
        this.num = num;
        this.count = count;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int[] answer = new int[k];
        PriorityQueue<Count> maxPriorityQueue = new PriorityQueue<Count>((o1, o2) -> o2.count- o1.count );
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(int key : map.keySet()){
          maxPriorityQueue.offer(new Count(key,map.get(key)));
        }

        for(int i = 0 ; i < k ; i++){
            Count a = maxPriorityQueue.poll();
            answer[i] =a.num;
        }

        return answer;

    }
}
```
