import java.util.*;

class Solution {
  long max;

  public long solution(String expression) {
    max = 0;
    String[] numArray = expression.split("[*+-]");
    String[] operatorArray = expression.split("0-9");

    List<String> numList = new ArrayList<>();
    List<String> operatorList = new ArrayList<>();
    List<String> operatorOrderList = new ArrayList<>();

    for (String num : numArray) {
      numList.add(num);
    }

    for (String operator : operatorArray) {
      operatorList.add(operator);
    }

    operatorOrderList.add("*");
    operatorOrderList.add("-");
    operatorOrderList.add("+");

    dfs(numList, operatorList, operatorOrderList);

    return max;
  }

  public void dfs(List<String> numList, List<String> operatorList, List<String> operatorOrderList) {

    if (numList.size() == 1) {
      max = Math.max(max, Math.abs(Integer.parseInt(numList.get(0))));
    }

    for (int k = 0; k < operatorOrderList.size() - 1; k++) {
      List<String> numList2 = new ArrayList<>(numList.size());
      Collections.copy(numList2, numList);
      List<String> operatorList2 = new ArrayList<>(operatorList.size());
      Collections.copy(operatorList2, operatorList);
      int i = 0;
      for (Iterator<String> it = operatorList2.iterator(); it.hasNext(); i++) {
        if (operatorOrderList.get(k).equals(it.next())) {
          it.remove();
          String a1 = numList2.remove(i);
          String a2 = numList2.remove(i + 1);
          if (operatorOrderList.get(k).equals("*")) {
            numList.add(i, Integer.toString(Integer.parseInt(a1) * Integer.parseInt(a2)));
          } else if (operatorOrderList.get(k).equals("+")) {
            numList.add(i, Integer.toString(Integer.parseInt(a1) + Integer.parseInt(a2)));
          } else if (operatorOrderList.get(k).equals("-")) {
            numList.add(i, Integer.toString(Integer.parseInt(a1) - Integer.parseInt(a2)));
          }
        } // if
      } // for
      String tmp = operatorOrderList.remove(k);
      dfs(numList2, operatorList, operatorOrderList);
      operatorOrderList.add(k, tmp);
      // 여기서 recu
    } // for
  }

}