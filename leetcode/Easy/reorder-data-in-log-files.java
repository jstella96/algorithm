
/*
	[풀이 과정]
		받은 로그를 digit 와 letter에 따로 저장한다. 정렬이 필요한 부분은 letter이므로 해당
		List만 정렬 후 다시 두개의 로그를 합쳐서 반환한다.
		이때 letterList의 경우 정렬기준이 2개이므로 로직에 신경써야 한다.
*/
import java.util.*;

class Solution {
  public String[] reorderLogFiles(String[] logs) {
    List<String> digits = new ArrayList<>();
    List<String> letters = new ArrayList<>();

    for (String log : logs) {
      if (Character.isDigit(log.charAt(log.length() - 1))) {
        digits.add(log);
      } else {
        letters.add(log);
      }
    }
    // 핵심코드
    letters.sort((s1, s2) -> {
      int index1 = s1.indexOf(" ");
      int index2 = s2.indexOf(" ");
      String identifiers1 = s1.substring(0, index1);
      String identifiers2 = s2.substring(0, index2);
      String log1 = s1.substring(index1 + 1);
      String log2 = s2.substring(index2 + 1);
      return log1.equals(log2) ? identifiers1.compareTo(identifiers2) : log1.compareTo(log2);
    });

    letters.addAll(digits);
    return letters.toArray(new String[letters.size()]);// logs.length

  }
}