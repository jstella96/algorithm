# valid-palindrome

[문제링크](https://leetcode.com/problems/valid-palindrome/)

## 문제 설명

모든 대문자를 소문자로 변환하고 영숫자가 아닌 문자를 모두 제거한 후 앞뒤로 동일하게 읽는 경우 해당 문자열은 palindrome 이다.  
문자열 `s`가 주어지면 palindrome이면 true를 반환하고 그렇지 않으면 false를 반환해라.

## 문제 풀이

StringBuffer에 정제된(문자가 아닌 것들을 제거 + uppercase) 문자열을 만들고,
for(len/2)문 안에서 양끝을 비교한다.

## 풀이 코드

```java
class Solution {
    public boolean isPalindrome(String s) {

        StringBuffer sb = new StringBuffer();
        char[] arrChar = s.toUpperCase().toCharArray();

        for(char ch : arrChar){
            if(Character.isLetterOrDigit(ch))
                sb.append(ch);
        }

        int len = sb.length();
				for(int i=0; i < len/2 ; i++){ //
					if(sb.charAt(i) != sb.charAt((len-1)-i)) return false;
				}

		    return true;
    }
}
```
