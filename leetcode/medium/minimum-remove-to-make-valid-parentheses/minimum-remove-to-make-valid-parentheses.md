# minimum-remove-to-make-valid-parentheses

[문제 링크](https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/)

## 문제 설명

'(' , ')' 및 소문자 영어 문자로 이루어진 문자열 s가 제공됩니다. 괄호 문자열이 유효하도록 최소 수의 괄호('(' 또는 ')'를 제거해서 반환하시오. 여기서 유효하다는 것은 '(A)' 처럼 괄호가 정상적으로 닫혀있다는 것을 말합니다.

## 문제 풀이

1. 주어진 문자열을 순회하면서 stack에 해당 값들을 저장한다. 이때 `openCount` 변수에 '('경우에는 +1 ')'일 경우에는 -1을 체크해준다.
   만약 `openCount` 변수의 값이 0보다 크지 않으면 그때 들어오는 ')'값은 유효하지 않기 때문에 stack에 넣지 않는다.

2. 그 후 해당 stack을 대상으로 `closeCount` 값을 계산하고 유효하지 않은 '('을 제거하는 과정을 거쳐주면 답이 나온다.

## 풀이코드

```java

import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String str) {

        String answer = "";
        int openCount = 0;
        Stack<Character> stack = new Stack<Character>();

        for(char x : str.toCharArray()){
            if( x != ')' ){ // close 문자가 아니면 답에 바로 넣기
                stack.push(x);
                if(x == '('){
                    openCount++;
                }
            }else if( openCount > 0){ //close 문자인데 openNum이 0 이 아니면 // 이부분으로 인해 유효하지 않은 ')'부분은 제거된다.
                openCount--;
                stack.push(x);
            }
	    }//for

        Stack<Character> answerStack = new Stack<Character>();
        int closeCount =0;
         while(!stack.isEmpty()){
             char ch = stack.pop();
            if( !( ch == '(' && closeCount == 0 ) ){ // 이부분으로 인해 유효하지 않은 '('부분은 제거된다.
                answerStack.push(ch);
                if( ch == ')'){
                    closeCount++;
                }
                else if( ch == '('){
                    closeCount--;
                }
            }
        }

        while(!answerStack.isEmpty()){
            answer += answerStack.pop();
        }

        return answer;

    }
}


```
