```java

/*
// (,[,{,},],) 외에는 안들어 오는거 같음
*/
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        for(char ch : charArr) {
            //문자가 여는 괄호 일때 push
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }
            else if(stack.empty())
                return false;
            else if(ch == ')' && stack.pop() != '(' )
                return false;
            else if(ch == ']' && stack.pop() != '[')
                return false;
            else if(ch == '}' && stack.pop() != '{')
                return false;
        }
        //비어있지 않으면 ( 한개 남은 것
        return stack.empty();
    }
}
```
