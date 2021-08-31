/*
	[풀이과정 - 1]
	-> 재귀함수를 사용했으나, list로 인해서 시간복잡도와 공간복잡도가 굉장히 안좋은 풀이가 된다.
	-> 시작길이를 알수 없어서 배열을 사용 못 한다는걸 염두에 두고 다른 풀이방법을 생각해 봤어야한다. 
	-> 다시풀기.....
 */
class Solution {
  public boolean isPalindrome(ListNode head) {
    ArrayList list = new ArrayList();
    return recur(head, list, 0);
  }

  public boolean recur(ListNode node, ArrayList list, int index) {
    list.add(node.val);
    if (node.next != null) {
      Boolean palindromeCheck = recur(node.next, list, index + 1);
      if (!palindromeCheck)
        return false;
    }
    if (list.get(list.size() - index - 1) == list.get(index)) {
      return true;
    } else {
      return false;
    }
  }
}