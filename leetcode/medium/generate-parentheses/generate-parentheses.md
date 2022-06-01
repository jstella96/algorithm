# generate-parentheses

[문제링크](https://leetcode.com/problems/generate-parentheses/)

## 문제 설명

정수 `n` 이 주어 졌을때 n쌍의 괄호조합으로 올바른 형식의 괄호 조합을 모두 생성하는 함수를 작성합니다.

## 입출력 예시

```
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
```

## 문제 풀이

) : n개

( : n개

open < n 일때 open 넣 을 수 있다.

close < open 일때만 close 넣을 수 있다.

## 풀이 코드

```java
/* 매번 (와 )를 더하면서 괄호쌍을 만들어나가는 대신에, 올바른 괄호쌍의 형태를 유지하고 있을때만 더해준다.
이 방법을 이용하기 위해 현재 열린 괄호와 닫힌 괄호를 체크해준다.
만약 현재 여는 괄호의 개수가 n보다 작은 상태라면 일단 여는 괄호를 추가한다.
그리고 여는 괄호의 수만큼 닫힌 괄호도 필요하므로, 닫힌 괄호의 수가 여는 괄호의 수보다 작다면 닫힌 괄호를 추가해준다.*/
class Solution {
	public List<String> generateParenthesis(int n) {
    	List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int n) {
    	if(cur.length() == n * 2) {
        	ans.add(cur);
            return;
        }
        if (open < n) {
        	backtrack(ans, cur + "(", open + 1, close, n);
        }
        if (close < open) {
        	backtrack(ans, cur + ")", open, close + 1, n);
        }
    }
 }
```
