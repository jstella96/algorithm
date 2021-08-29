class Solution {
  public String[] letters = { "", "", "abc", "def", "ghi", "kjl", "mno", "pqrs", "tuv", "wxyz" };
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