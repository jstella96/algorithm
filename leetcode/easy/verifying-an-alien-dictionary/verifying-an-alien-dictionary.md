# verifying-an-alien-dictionary

## 풀이코드

```java
/*
	[풀이 과정]
		words = 단어장 단어 순서 , order = 알파벳 순서
		외계인은 지구와 알파벳의 순서가 다르다. 외계인의 알파벳순서로 봤을 때 단어장의 단어 순서가
		올바르다면 true, 아니라면 false 반환
		order을 char로 잘라서 (알파벳,순서(0~25))에 입력
		words를 for( words.length-1 ) 돌리면서 포인트 단어와 뒷 단어체크
		각 단어를 char[] 로 분해 후
		포인트 단어길이 만큼 for문 상황에 맞는 return/ break
		해당 char이 같을 때만  for문 계속 실행
	[수정]
		길이 체크 부분 없앨 수 있는 코드는?
*/
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
