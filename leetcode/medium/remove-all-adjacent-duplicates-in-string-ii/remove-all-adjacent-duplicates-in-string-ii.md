# remove-all-adjacent-duplicates-in-string-ii

[문제링크](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/)

## 문제 설명

문자열 `s`와 정수 `k`가 주어지면 s에서 k개의 인접하고 동일한 문자를 선택하고 제거하여 삭제된 부분 문자열의 왼쪽과 오른쪽이 함께 연결되도록 한다. 더 이상 할 수 없을 때까지 k개의 중복 제거를 반복적으로 수행한 후 최종 문자열을 반환합니다. 답변이 고유함이 보장 됩니다.

## 입출력 예시

```
Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
첫번째로 "eee" 와 "ccc" 를 지운후 "ddbbbdaa"를 얻을 수 있다.
그후 "bbb"를 지워 "dddaa"를 얻고 마지막으로 "ddd"를 지워
최종 답인 "aa"를 얻는다.
```

## 문제 풀이

stack에 문자열을 쌓는다. 이때 같은 문자열이 연속으로 들어오면 count를 센다. count == k가 될때 해당 부분은 삭제해준다.

## 풀이 코드

```java
class Count
{
    char ch;
    int count;

    Count(char ch, int count)
    {
        this.ch = ch;
        this.count = count;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Count> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            if (stack.empty())
            {
                stack.push(new Count(s.charAt(i), 1));
            }
            else
            {
                Count prev = stack.peek();
                if (prev.ch == s.charAt(i))
                {
                    if(prev.count + 1 == k){
                        for (int z = 0; z < prev.count; z++)
                        {
                            stack.pop();
                        }
                    }else{
                        stack.push(new Count(s.charAt(i), prev.count + 1));
                    }
                }
                else
                {
                    stack.push(new Count(s.charAt(i), 1));
                }
            }
        }

        //검색. reseverse 함수 문자열 뒤집기
        StringBuilder sb = new StringBuilder();
        while(stack.size() != 0) sb.append(stack.pop().ch);
        sb.reverse();
        return sb.toString();
    }
}
```
