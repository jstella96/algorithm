package java;

import java.util.*;

class Solution {
  public String solution(int n, int k, String[] cmd) {
    ArrayList<Integer> checkList = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      checkList.add(i);
    }
    Stack<Integer> delTableIndex = new Stack<Integer>();
    Stack<Integer> delOriginIndex = new Stack<Integer>();
    int currIdx = k;
    for (String aCmd : cmd) {
      String[] str = aCmd.split(" ");
      // "U X": 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
      if (str[0].equals("U")) {
        currIdx = currIdx - Integer.parseInt(str[1]) > 0 ? currIdx - Integer.parseInt(str[1]) : 0;
        // "D X": 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.
      } else if (str[0].equals("D")) {
        currIdx = currIdx + Integer.parseInt(str[1]) < checkList.size() ? currIdx + Integer.parseInt(str[1])
            : checkList.size() - 1;
        // "C" : 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
      } else if (str[0].equals("C")) {
        Integer delIdx = checkList.remove(currIdx);
        if(currIdx > checkList.size()) currIdx= currIdx - 1;
        delOriginIndex.push(delIdx);
        delTableIndex.push(currIdx);
        // "Z" : 가장 최근에 삭제된 행을 원래대로 복구합니다. 단, 현재 선택된 행은 바뀌지 않습니다.
      } else if (str[0].equals("Z")) {
        checkList.add(delTableIndex.pop(), delOriginIndex.pop());
      }
 
    }
    //마지막 작업  del에있는거 제거 
    HashSet<Integer> set = new HashSet<Integer>();
    for(int idx : delOriginIndex){
      set.add(idx);
    }   
    StringBuffer sb = new StringBuffer();
    for(int z = 0; z < n ; z++){
      if(set.contains(z)){
        sb.append("X");
      }else{
        sb.append("O");
      }
    }
    return sb.toString();
  }
}