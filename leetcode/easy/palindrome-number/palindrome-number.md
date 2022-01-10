# Palindrome Number

## 풀이 코드

<두번 쨰 풀이>

```java
//두번째 풀이 : 속도 향상 됐으나 더 좋은 방법찾아보기. 아직 속도가 안나옴
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

<첫번 쨰 풀이>

```java
//첫 번째 풀이 속도가 안나옴.
import java.util.*;
class Solution {
    public boolean isPalindrome(int x) {
    //char 순서대로 배열에 .
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
