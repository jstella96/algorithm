- stack은 구덩이같은 구조이다.
- 구조 : LIFO(last in first out)

```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>(); //int형 스택 선언
Stack<String> stack = new Stack<>(); //char형 스택 선언
Stack<Character> stack = new Stack<>(); //char형 스택 선언

stack.push();    // 데이터 추가
stack.pop();     // 최근에 추가된(Top) 데이터 삭제, 비어있으면 EmptyStackException 발생
stack.peek();    //최근 추가된(top) 데이터 조회, 비어있으면 EmptyStackException 발생
stack.isEmpty()) //stack의 값이 비었는지 확인
stack.empty()    // stack의 값이 비었는지 확인, 비었으면 true, 아니면 false
stack.seach(Object o); // 인자값으로 받은 데이터의 위치 반환, 위치가 1부터 시작
stack.clear();   // stack의 전체 값 제거 (초기화)
stack.size();    // stack 사이즈
stack.contains(x)// stack에 x값이 있는지 체크 (있다면 true)
stack.get(i) //index 입력하면 해당 객체 하면 가져옴

//확장 for 문가능 / foreach 도 된다.
for(String str : stack) { //stack에 있는 모든 String 출력.
			System.out.println(str);//스택에 있는 원소를 출력하는 것이므로
															//stack 순으로 출력되는 것은 아니다. pop()연산 아님.
}
for(int i=0;i<stack.size();i++){
			System.out.println(stack.pop()); //stack 순으로
}
```

- queue는 통로같은 구조이다.
- FIFO(Firstlast in first out)

```java
import java.util.LinkedList;
import java.util.Queue;

Queue<Integer> queue = new LinkedList<>(); //int형 queue 선언, linkedlist 이용
Queue<String> queue = new LinkedList<>(); //String형 queue 선언, linkedlist 이용

queue.offer() //queue에 객체를 저장 성공:true 실패:false
queue.poll(); //queue에 첫번째 객체를 꺼내서 반환 비어있다면 null
queue.peek(); //queue의 첫번째 객체를 삭제없이 반환 비어있다면 null
//--<에러발생>--
queue.add()     //queue에 객체를 저장 성공:true 저장공간부족시 illegalStateException 발생
queue.remove(); //queue에 첫번째 객체 꺼내서 반환 비어 있으면 NoSuchElementException 발생
queue.element() //queue에 첫번째 객체를 삭제없이 반환 비어 있으면  NoSuchElementException 발생
//그외
queue.clear();   // queue 초기화
queue.contains(x);// queue안에 x의 존재가 있는가
queue.isEmpty(); // queue가 비었는지 확인
queue.size();// queue 크기
```

**[읽어보기]**

[https://tosuccess.tistory.com/155](https://tosuccess.tistory.com/155)
