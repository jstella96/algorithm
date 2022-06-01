# most-common-word

[문제링크](https://leetcode.com/problems/most-common-word/)

## 문제 설명

금지된 단어의 문자열 단락과 문자열 배열이 주어지면 금지되지 않은 가장 빈번한 단어를 반환합니다.  
금지되지 않은 단어가 하나 이상 있고, 답변이 고유하다는 것이 보장됩니다.  
단락의 단어는 대소문자를 구분하지 않으며 답변은 소문자로 반환되어야 합니다.

## 문제 풀이

받은 문자열을 전처리 후 띄어쓰기 기준으로 split 하여 배열에 넣는다
금지단어는 set에 넣어준다 - > 포함여부 검증시 속도를 O(1)으로 만들기 위해서
문자열배열을 for문으로 순회하면서 금지단어가 아닌 문자들만 map에 넣으면서 카운트를 세어준다.
이때 max count 와 이때 해당하는 문자를 전역변수에 저장하고 for문이 끝난 후 해당문자를 반환

## 풀이 코드

```java
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        String[] words = paragraph.replaceAll("[\\!\\?',;\\.]", " ").toLowerCase().split("\\s+");
        //System.out.println(paragraph.replaceAll("[\\!\\?',;\\.]", " ").toLowerCase());
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        HashSet<String> bannedSet = new HashSet<>(banned.length);
        for(String  str : banned){
           bannedSet.add(str);
        }
        int maxCount = 0;
        String maxWord = "";
        for(String  str : words){
            if(!bannedSet.contains(str)){
                int wordCount = wordCountMap.getOrDefault(str ,0) + 1 ;
                wordCountMap.put( str, wordCount );
                if( wordCount >= maxCount){
                    maxCount = wordCount;
                    maxWord = str;
                }
            }
        }

        return maxWord;
    }
}
```
