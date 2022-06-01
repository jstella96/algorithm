
# word-break-ii

[문제링크](https://leetcode.com/problems/word-break-ii/)

## 문제 설명

문자열 `s`와 문자열 배열 `wordDict`가 주어졌을 때, 문자열 s에 공백을 추가하여 각 단어가 유효한 사전 단어인 문장을 구성할 수 있다. 가능한 모든 문장을 임의의 순서로 반환해라. 사전에 있는 동일한 단어는 분할에서 여러 번 재사용될 수 있습니다.

## 문제 예시

```
Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
```

## 풀이 코드

```java
class Solution {
    public List<String> wordBreak(String s, List<String> dict) {
        List<String> result = new ArrayList<String>();
        //마지막 단어가 포함 되냐 안되냐를 검증."" 없으면빈값이지. 제거 대상.
        for(int j = s.length() - 1; j >= 0; j--){
            if(dict.contains(s.substring(j)))
                break;
            else{
                if(j == 0)
                    return result;
            }
        }
        for(int i = 0; i < s.length()-1; i++)//핵심 cat 일떄. cats 일때. cat이면 send 일때. 랑,. 2,,3 개면 그것도 포함
        {
            if(dict.contains(s.substring(0,i+1)))
            {
                List<String> strs = wordBreak(s.substring(i+1,s.length()),dict);
                if(strs.size() != 0)
                    for(Iterator<String> it = strs.iterator();it.hasNext();)
                    {
                        result.add(s.substring(0,i+1)+" "+it.next());
                    }
            }
        }
        if(dict.contains(s)) result.add(s); //마지막 단어 위해.
        return result;
    }
}
```
