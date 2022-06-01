# Palindrome Number

[문제링크](https://leetcode.com/problems/palindrome-number/)

## 문제 설명

정수 `x`가 주어질때, x가 회문 정수이면 true를 반환합니다. 121은 회문이지만 123은 그렇지 않습니다.

## 문제 풀이

풀이1: 투포인터 이용  
정수를 한글자씩 자른 후 양 끝에서 부터 비교한다 O(1/2n)만에 해결할 수 있다.

풀이2: 스택 이용  
정수를 한글자씩 자른 후 먼저 스택에 모든 값을 넣어 논 후 다시 스택에서 값을 역으로 빼면서 검증한다. FILO성질을 이용한 풀이, 그러나 시간복잡도 상으로 풀이1이 더 성능이 좋다.

## 풀이 코드

풀이1.투포인터

```java
class Solution {
    public boolean isPalindrome(int x) {
    //char 순서대로 배열에.
    String str = Integer.toString(x); //tochar..쓰려고 변환
    char[] chs = str.toCharArray(); // 배열로 변환
		int len = chs.length;
		for(int i=0; i < len/2; i++){ //  int '/'니까 몫만 저장
			if(chs[i] != chs[(len-1)-i]) return false; // 반만 검증
		}
        return true;
    }
}
```

풀이2.스택

```java
import java.util.*;
class Solution {
    public boolean isPalindrome(int x) {
    //char 순서대로 배열에
    String str = Integer.toString(x);
		Stack<Character> stack = new Stack<>();
		for(char num : str.toCharArray()){
			stack.push(num);
		}
    //풀이
    for(char num : str.toCharArray()){
			if(num != stack.pop()) return false;
		}
        return true;
    }
}
```

