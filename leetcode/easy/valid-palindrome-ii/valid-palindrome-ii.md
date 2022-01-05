# Valid Palindrome II

## 문제

String `s`가 주어진다. `s`에서 **최대 한 문자**만 삭제한 후 palindrome이 될 수 있다면 `true`를 리턴해라

## 예시

```
Example 1:
Input: s = "aba"
Output: true
```

```
Example 2:
Input: s = "abca"
Output: true
Explanation: 'c'를 삭제하면 'aba'이므로 palindrome이다
```

```
Example 3:
Input: s = "abc"
Output: false
```

## 문제 풀이

재귀함수 사용한다

실패 풀이

```
class Solution {
      public boolean validPalindrome(String s) {
    char[] ch = s.toCharArray();
    int leftCount = 0;
    int rightCount = 0;
    int len = s.length() - 1;
    for (int i = 0; i < len / 2; i++) {

      int leftPoint = i + leftCount;
      int rightPoint = len - i - rightCount;
        System.out.println(leftPoint);
        System.out.println(rightPoint );
      if (ch[leftPoint] != ch[rightPoint]) {
        if (ch[leftPoint + 1] == ch[rightPoint]) {
          leftCount++;
        } else if (ch[leftPoint] == ch[rightPoint - 1]) {
          rightCount++;
        } else{
            return false;
        }
      }
      if (leftCount + rightCount > 1)
        return false;
    }
    return  true;
  }
}
```

풀이

```
class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while (l<=r){
            if (s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }
            else{
                return isPalindrome(s,l,r-1) || isPalindrome(s,l+1,r);
            }
        }
        return true;
    }

    private boolean isPalindrome(String str, int s, int t){
        while (s <= t){
            if (str.charAt(s) == str.charAt(t)){
                s++;
                t--;
            }
            else
                return false;
        }

        return true;
    }
}
```
