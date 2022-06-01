# Top K Frequent Elements

[문제링크](https://leetcode.com/problems/top-k-frequent-elements/)

## 문제 설명

정수 배열 `nums`와 정수 `k`가 주어지면 k개의 가장 빈번한 요소를 반환합니다. 어떤 순서로든 답을 반환할 수 있습니다.

## 입출력 예시

```
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
```

## 문제 풀이

map에 1차 계산 후 정렬방식을 map.get(k) 로 바꿔서 정렬 후 뺀다.

## 풀이 코드

```java
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
