# reverse-string

[문제링크](https://leetcode.com/problems/reverse-string/)

## 문제 설명

문자열을 뒤집는 함수를 작성하십시오. 입력 문자열은 배열로 제공됩니다.
O(1) 추가 메모리를 사용하여 제자리에서 입력 배열을 수정하여 이 작업을 수행해야 합니다.

## 입출력 예시

```
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
```

## 문제 풀이

two pointer

## 풀이 코드

```java

class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        for(int i = 0; i < len/2 ; i++ ){
            char tmp = s[i];
            s[i] = s[len-1-i];
            s[len-1-i] = tmp;
        }
    }
}
```
