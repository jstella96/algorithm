# LRUCache

## 풀이 방법

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
