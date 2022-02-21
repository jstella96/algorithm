# remove-all-adjacent-duplicates-in-string-ii

## 문제 설명

문자열 s와 정수 k가 주어지면 s문자열에서 에서 k개의 인접하고 동일한 문자를 선택하고 제거하여 삭제된 부분 문자열의 왼쪽과 오른쪽이 함께 연결되도록 하는 것으로 구성된다.
더 이상 할 수 없을 때까지 k개의 중복 제거를 반복적으로 수행한다.
이러한 모든 중복 제거가 수행된 후 최종 문자열을 반환한다.

## 예시

```
Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
```

1. "eee" "ccc", 삭제되고 "ddbbbdaa" 가 남는다.
2. "bbb" 삭제되고 get "dddaa" 가 남는다.
3. 마지막으로 "ddd" 삭제되고 "aa" 가 남는다.

## 풀이 코드

```java
/*
	[풀이 과정] -
		카운트계산해서 k값 되면 pop으로 삭제
*/
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
