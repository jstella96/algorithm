
/*
	[풀이 과정]
		받은 문자열을 전처리 후 띄어쓰기 기준으로 split 하여 배열에 넣는다
		금지단어는 set에 넣어준다 - > 포함여부 검증시 속도를 O(1)으로 만들기 위해서
		문자열배열을 for문으로 순회하면서 금지단어가 아닌 문자들만 map에 넣으면서 카운트를 세어준다.
		이때 max count 와 이때 해당하는 문자를 전역변수에 저장하고 for문이 끝난 후 해당문자를 반환
	[수정]
		정규표현식 [^a-zA-Z] 이게 더 읽기 좋다
		split(" ")  = > split("\\s+") 기억하기
		마지막 최대값을 검색을 더 깔끔하게 변환할 수 있는 부분이 있다면 좋을꺼 같다.  
*/
import java.util.*;

class Solution {
  public String mostCommonWord(String paragraph, String[] banned) {

    String[] words = paragraph.replaceAll("[\\!\\?',;\\.]", " ").toLowerCase().split("\\s+");
    // System.out.println(paragraph.replaceAll("[\\!\\?',;\\.]", "
    // ").toLowerCase());
    HashMap<String, Integer> wordCountMap = new HashMap<>();
    HashSet<String> bannedSet = new HashSet<>(banned.length);
    for (String str : banned) {
      bannedSet.add(str);
    }
    int maxCount = 0;
    String maxWord = "";
    for (String str : words) {
      if (!bannedSet.contains(str)) {
        int wordCount = wordCountMap.getOrDefault(str, 0) + 1;
        wordCountMap.put(str, wordCount);
        if (wordCount >= maxCount) {
          maxCount = wordCount;
          maxWord = str;
        }
      }
    }

    return maxWord;
  }
}