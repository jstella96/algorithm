# word-break

[문제링크](https://leetcode.com/problems/word-break/)

## 문제 설명

문자열 `str`과 `word`가 주어지는데 해당 `word`를 조합해서 `str`을 만들 수 있는가?


## 문제 풀이

풀이1:  
메모리제이션을 해서 , String 을 자르면서 간다
풀이2:  
map 안에 key로 각 알파벳을 value에 list에 각 단어를 넣는다.
그 후 해당 str의 시작부분 알파벳에 해당하는 list를 돌려준다.
그단어만큼 앞을 자른 후 str이 다 사라질 때 까지 해당과정을 반복한다. 하나의 루트라도 true가 나오면 된다.

**주의점**: subSting은 O(1)이 아니다.

## 풀이 코드

```java
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakMemo(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean wordBreakMemo(String s, Set<String> wordDict, int startIndex, Boolean[] memo) {
        if (startIndex == s.length()) {
            return true;
        } //예외처리1
        if (memo[startIndex] != null) { //이미 방문했다. 있다.
            return memo[startIndex];
        }
        for (int end = startIndex + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(startIndex, end)) && wordBreakMemo(s, wordDict, end, memo)) { //앞에서 자른 값과, 뒤에있는 값들로도 재귀를 돌렸을 때 true 라면
                return memo[startIndex] = true;
            }
        }
        return memo[startIndex] = false;
    }
}
```
