# reorder-data-in-log-files


[문제링크](https://leetcode.com/problems/reorder-data-in-log-files/)

## 문제 설명

로그 배열이 제공됩니다. 각 로그는 공백으로 구분된 단어 문자열이며 첫 번째 단어는 식별자입니다.  
두 가지 유형의 로그가 있습니다.

- Letter-logs: 모든 단어(식별자 제외)는 영문 소문자로 구성됩니다.
- Digit-logs: 모든 단어(식별자 제외)는 숫자로 구성됩니다.

다음과 같이 로그를 재정렬합니다. 문자 로그는 모든 숫자 로그 앞에 옵니다. 편지 로그는 내용에 따라 사전순으로 정렬됩니다. 내용이 같으면 식별자를 기준으로 사전순으로 정렬합니다. 숫자 로그는 상대적인 순서를 유지합니다. 로그의 최종 순서를 반환합니다.

## 문제 풀이

받은 로그를 digit 와 letter에 따로 저장한다. 정렬이 필요한 부분은 letter이므로 해당
List만 정렬 후 다시 두개의 로그를 합쳐서 반환한다.
이때 letterList의 경우 정렬기준이 2개이므로 로직에 신경써야 한다.

## 풀이 코드

```java
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digits = new ArrayList<>();
        List<String> letters = new ArrayList<>();

        for(String log : logs){
            if( Character.isDigit(log.charAt(log.length()-1)) ){
                digits.add(log);
            }else{
                letters.add(log);
            }
        }
        //핵심코드
        letters.sort((s1,s2) -> {
            int index1 = s1.indexOf(" ");
            int index2 = s2.indexOf(" ");
            String identifiers1 = s1.substring(0, index1);
            String identifiers2 = s2.substring(0, index2);
            String log1 = s1.substring(index1+1);
            String log2 = s2.substring(index2+1);
            return log1.equals(log2) ? identifiers1.compareTo(identifiers2) : log1.compareTo(log2);
        });

        letters.addAll(digits);
        return letters.toArray(new String[letters.size()]);//logs.length

    }
}
```
