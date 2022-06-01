# decode-string

[문제링크](https://leetcode.com/problems/tweet-counts-per-frequency/)

## 문제 설명

인코딩된 문자열이 주어지면 디코딩된 문자열을 반환합니다. 인코딩 규칙은 k[encoded_string]입니다. 여기서 대괄호 안의 encode_string은 정확히 k번 반복됩니다. k는 양의 정수로 보장됩니다. 입력 문자열이 항상 유효하다고 가정할 수 있습니다. 여백이 없고, 대괄호가 잘 구성되어 있습니다. 또한 원래 데이터에 숫자가 포함되어 있지 않고 숫자가 반복되는 숫자 k에 대해서만 있다고 가정할 수 있습니다. 예를 들어 3a 또는 2[4]와 같은 입력은 없습니다.

## 입출력예시

```
Input: s = "3[a]2[bc]"
Output: "aaabcbc"
```

## 문제 풀이

stack에 계속 넣고 ']'이 나올때 마다 꺼내서 재조립 한다.

## 풀이 코드

```java
class Solution {
    public String decodeString(String s) {
        //10을 곱해서
        Stack<Character> stack = new Stack<>(); //char형 스택 선언
        for(char ch : s.toCharArray()){
            if(ch == ']'){
                String tmp = "";
               // StringBuffer sb = new StringBuffer();
                while(!stack.peek().equals('[')){
                  // sb.append()
                    tmp += stack.pop();
                }
                stack.pop();
                String num = "";
                while( stack.size() != 0  && Character.isDigit(stack.peek()) ){
                    num = stack.pop() + num;
                }
                System.out.println(num);
                int size = Integer.parseInt(num);

                char[] tmpChar = tmp.toCharArray();
                for(int i = 0 ; i < size; i++ ){

                    for( int z = 0 ; z < tmpChar.length ; z++ ){
                        stack.push(tmpChar[tmpChar.length - 1 -z ]);
                    }
                }
            }else{
                stack.push(ch);
            }

        }

        String answer = "";
        for(int i=0; i<stack.size(); i++) answer+=stack.get(i);

        return answer;
    }
}
```
