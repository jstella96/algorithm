# verifying-an-alien-dictionary

[문제링크](https://leetcode.com/problems/verifying-an-alien-dictionary/)

## 문제 설명

`words` = 단어장 단어 순서, `order` = 알파벳 순서
외계인은 지구와 알파벳의 순서가 다르다. 외계인의 알파벳순서로 봤을 때 단어장의 단어 순서가 올바르다면 true, 아니라면 false 반환해라.

## 입출력 예시

```
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation:  'h'가 'l'보다 먼저 오기 때문에 단어사전은 정상이다.
```

## 문제 풀이

order을 char로 잘라서 map안에 (알파벳,순서(0~25))로 입력
words를 for문으로 순회하면서 해당 단어와 뒷 단어를 체크한다.
각 단어를 char[] 로 분해 후 같은 자리에 있는 문자를 비교한다.
해당 문자가 같을 때만 for문 계속 실행


## 풀이 코드

```java
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character ,Integer> map  = new HashMap<Character ,Integer>();
        char[] alphabet = order.toCharArray();
        for(int i=0; i< alphabet.length; i++){
            map.put(alphabet[i],i);
        }
        for(int i=0; i < words.length-1; i++){
            char[] word1 = words[i].toCharArray();
            char[] word2 = words[i+1].toCharArray();
            for(int z=0; z <word1.length; z++){
                if( z > word2.length-1 ) return false;
                if( map.get(word1[z]) > map.get(word2[z])) return false;
                if( map.get(word1[z]) < map.get(word2[z])) break;
            }
        }
        return true;
    }
}
```
