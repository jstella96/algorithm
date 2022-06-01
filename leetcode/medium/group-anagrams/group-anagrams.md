# group-anagrams


[문제링크](https://leetcode.com/problems/group-anagrams/)

## 문제 설명

문자열 배열이 `strs` 주어지면 Anagram을 반환하시오.
Anagram은 일반적으로 모든 원래 문자를 정확히 한 번 사용하여 다른 단어 또는 구의 문자를 재배열하여 형성된 단어 또는 구입니다.
예를 들어 "ate","eat","tea" 는 같은 알파벳인 a,t,e로 이루어져 있으므로 Anagram 그룹이다.

## 입출력 예시

```
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
```

## 문제 풀이

문자열을 문자 기준으로 정렬해서 Anagram이라면 같은 값이 나오게 한다.
정렬된 문자열을 key로 해서 해당되는 Anagram을 다 map의 value 값으로 넣는다.

## 풀이 코드

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String result = new String(charArr); //문자열 정렬해서 같은 모양으로
            if(!map.containsKey(result)) // 존재여부
						   map.put(result, new ArrayList<>());
						map.get(result).add(str);
        }
        return new ArrayList<>(map.values()); //이게 되네
    }
}
```
