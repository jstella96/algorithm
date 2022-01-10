# flatten-nested-list-iterator

## 풀이코드

```java
/*
		[풀이 과정]
			NestedIterator i = new NestedIterator(nestedList);
		  while (i.hasNext()) v[f()] = i.next();
			Input: nestedList = [[1,1],2,[1,1]]
			Output: [1,1,2,1,1]
			위 식이 성립되게 hasNext() 와 next()를 오버라이딩 하는 문제

			boolean isInteger();
			Integer getInteger();
			List<NestedInteger> getList();

			위 함수 사용 가능

			output 값을 queue에 담아두고 hasnext 와 next에 size/poll 로 판별하면 됨
*/
public class NestedIterator implements Iterator<Integer> {
    Queue<Integer> data = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        flatten(nestedList);
    }

    public void flatten(List<NestedInteger> list) {
        for (NestedInteger el : list)
            if (el.isInteger()) data.add(el.getInteger());
            else flatten(el.getList());
    }

		@Override
    public Integer next() { return data.poll(); }

		@Override
    public boolean hasNext() { return data.size() > 0; }
}
```
