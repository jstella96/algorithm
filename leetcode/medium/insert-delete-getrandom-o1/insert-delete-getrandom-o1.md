# insert-delete-getrandom-o1


[문제링크](https://leetcode.com/problems/balance-a-binary-search-tree/)

## 문제 설명

RandomizedSet 클래스를 구현합니다.

- RandomizedSet() RandomizedSet 개체를 초기화합니다.
- bool insert(int val) 존재하지 않는 경우 항목 val을 세트에 삽입합니다. 항목이 없으면 true를 반환하고 그렇지 않으면 false를 반환합니다.
- bool remove(int val) 존재하는 경우 세트에서 항목 val을 제거합니다. 항목이 있으면 true를 반환하고 그렇지 않으면 false를 반환합니다.
- int getRandom() 현재 요소 집합에서 임의의 요소를 반환합니다(이 메서드가 호출될 때 적어도 하나의 요소가 존재함을 보장합니다).

각 요소는 반환될 확률이 동일해야 합니다. 각 함수가 평균 O(1) 시간 복잡도에서 작동하도록 클래스의 함수를 구현해야 합니다.

## 풀이 코드

```java
public class RandomizedSet {

   LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();

    public boolean insert(int val) {
        if(set.contains(val)) {
            return false;
        }
        set.add(val);
        return true;
    }

    public boolean remove(int val) {
       return set.remove(val);

    }

    Random rnd = new Random();
    public int getRandom() {
        int size = set.size();
        int num =  rnd.nextInt(size);
        // Set -> 배열
        Integer[] arr = set.toArray(new Integer[size]); //배신
        return arr[num];
    }
}
```
