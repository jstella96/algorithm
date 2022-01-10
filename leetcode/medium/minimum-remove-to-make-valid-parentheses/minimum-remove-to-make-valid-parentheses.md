# minimum-remove-to-make-valid-parentheses

##

- 강태님 풀이
  - '(' 없으면 ')' ← stact x
  - '(' count stack push
  - location 을 stack 에 같이 저장 하면서
  - 나왔을 때 제거
  - '('값을 index를 넣는다.

## 풀이 코드

```java
// 풀어지지만 속도, 용량면 다 안좋음.
import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String str) {

        String answer = "";
        int openNum = 0;
        Stack<Character> stack = new Stack<Character>();

        for(char x : str.toCharArray()){
            if( x != ')' ){ // close 문자가 아니면 답에 바로 넣기
                stack.push(x);
                if(x == '('){
                    openNum++;
                }
            }else if( openNum > 0){ //close 문자인데 openNum이 0 이 아니면
                openNum--;
                stack.push(x);
            }
	    }//for

        Stack<Character> answerStack = new Stack<Character>();
        //최종 답 입력
        int closeNum =0;
         while(!stack.isEmpty()){
             char ch = stack.pop();
            if( !( ch == '(' && closeNum == 0 ) ){
                answerStack.push(ch);
                if( ch == ')'){
                    closeNum++;
                }
                else if( ch == '('){
                    closeNum--;
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
