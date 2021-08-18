/*
	[풀이 과정]
		StringBuffer에 정제된(문자가 아닌 것들을 제거 + uppercase) 문자열을 만들고,
		for(len/2)문 안에서 양끝을 비교한다. 
	[수정]
		변수명 더 의미있는 변수명으로 수정하기.
		isLetterOrDigit -> 보다는 정규표현식이나, 더 넓게 사용할 수 있는 함수를 사용.
  [시간복잡도]
    O(n)
*/
class Solution {
  public boolean isPalindrome(String s) {

    StringBuffer sb = new StringBuffer();
    char[] arrChar = s.toUpperCase().toCharArray();

    for (char ch : arrChar) {
      if (Character.isLetterOrDigit(ch))
        sb.append(ch);
    }

    int len = sb.length();
    for (int i = 0; i < len / 2; i++) { //
      if (sb.charAt(i) != sb.charAt((len - 1) - i))
        return false;
    }

    return true;
  }
}