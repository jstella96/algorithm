
/*
  [풀이 과정]
    각 숫자를 스트링 값으로 바꿔준다.
    sort 기준을 문자열 (o2 + o1).compareTo(o1 + o2) 로 바꿔 주게 되면. 
    합친 값이 더 큰쪽으로 정렬 하게 된다.
  [예외 처리]
  "0000000000" 이 결과값일 경우 "0"으로 응답해야한다.
   strNums[0].equals("0")일 경우 return "0" 해준다.
*/
import java.util.*;

class Solution {
  public String solution(int[] numbers) {
    StringBuilder answer = new StringBuilder();
    String[] strNums = new String[numbers.length];

    for (int i = 0; i < numbers.length; i++) {
      strNums[i] = String.valueOf(numbers[i]);
    }

    Arrays.sort(strNums, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return ((o2 + o1).compareTo(o1 + o2));
      }
    });

    for (int i = 0; i < strNums.length; i++) {
      if (i == 0 && strNums[i].equals("0"))
        return "0"; // 첫번째가 0이면
      answer.append(strNums[i]);
    }

    return answer.toString();
  }
}