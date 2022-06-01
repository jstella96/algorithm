# letter-combinations-of-a-phone-number

[문제링크](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

## 문제 설명

2-9의 숫자로 이루어진 문자열이 주어질 때, 숫자가 표현할 수 있는 모든 가능한 문자 조합을 구하여라. 각 숫자가 나타낼 수 있는 문자의 리스트는 아래 그림과 같다. 1은 어떤 문자도 나타낼 수 없다

- 숫자매핑은 위 문제링크 참고.
  `letters = {"", "", "abc", "def", "ghi", "kjl", "mno", "pqrs", "tuv", "wxyz"}` 각 인덱스에 매핑

## 입출력 예시

```
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
```

## 문제 풀이

먼저 2 에 해당하는 문자 하나씩 넣어주고
그다음 3에 해당하는 문자하나씩 넣어주고
그다음 숫자에 해당하는 숫자 하나씩 넣어주고

a^b
a = digit.length  
b = 한 숫자가 가질 수 있는 문자 갯수

## 풀이 코드

```java
class Solution {
    public String[] letters = {"", "", "abc", "def", "ghi", "kjl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> result;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<String>();

        if (digits.length() > 0) {
            comb(0, new StringBuilder(), digits.toCharArray());
        }
        return result;
    }

    public void comb(int pick, StringBuilder sb, char[] order) {
        // 뽑은 개수 == 문자열의 길이 : 다 뽑읍
        if (pick == order.length) {
            result.add(sb.toString());
            return;
        }

        // 해당 번호를 눌렀을 때 입력 가능한 캐릭터 배열
        char[] charArr = letters[Character.getNumericValue(order[pick])].toCharArray();

        // 배열을 돌면서 입력했다가 다시 빼기
        for (int i = 0; i < charArr.length; i++) {
            sb.append(charArr[i]);
            comb(pick + 1, sb, order);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
```
