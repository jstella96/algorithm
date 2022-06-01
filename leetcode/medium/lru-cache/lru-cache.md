# LRUCache

[문제링크](https://leetcode.com/problems/lru-cache/)

## 문제 설명

LRU 캐시의 제약 조건을 따르는 데이터 구조를 설계합니다. LRUCache 클래스를 구현합니다.

- LRUCache(int capacity): `capacity` 용량으로 LRU 캐시를 초기화합니다.
- int get(int key): 키가 있으면 키 값을 반환하고, 그렇지 않으면 -1을 반환합니다.
- void put(int key, int value): 키가 있는 경우 키 값을 업데이트합니다. 그렇지 않으면 키-값 쌍을 캐시에 추가합니다. 키 수가 이 작업의 용량을 초과하는 경우 least recently used key(LRU key) 가장 오랫동안 참조되지 않은키를 제거합니다.

get 및 put 함수는 각각 O(1) 평균 시간 복잡도에서 실행되어야 합니다.

## 입출력 예시

```
Input:
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output:
[null, null, null, 1, null, -1, null, -1, 3, 4]
```

## 문제 풀이

map에 데이터를 저장하고 queue를 이용해 가장 오랫동안 참조되지 않은 키를 구별한다.
그러나 위 풀이는 queue.remove()를 사용해야 되기 때문에 시간복잡도가 o(n)이다.
O(n) -> O(1) 되는 법은..? 참조된 키에 대한 시간을 저장한다?

## 풀이 코드

```java
class LRUCache
{
    int capacity;
    Queue<Integer> queue = new ArrayDeque<>();
    Map<Integer,Integer> map=new LinkedHashMap<>();

    public LRUCache(int capacity)
    {
        this.capacity = capacity;//cache size
    }

    public int get(int key)
    {
        if (map.containsKey(key))
        {
            queue.remove(key);//O(n)
            queue.offer(key);//O(1)
            return map.get(key);//O(1)
        }
        else
            return -1;
    }

    public void put(int key, int value)
    {
        if(map.containsKey(key)){
            queue.remove(key);
        }
        else if(queue.size() == capacity){
            map.remove(queue.poll());
        }
        queue.offer(key);
        map.put(key,value);
    }
}
```
