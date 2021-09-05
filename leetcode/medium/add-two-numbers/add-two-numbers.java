/*
		[풀이과정]
    carry = sum / 10;//몫
    curr.next = new ListNode(sum % 10); //나머지
		이부분을 생각하는게 어려운 문제.. 이건 알아야푼다

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
*/
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode curr = dummyHead; // 포인트
    int carry = 0;

    while (l1 != null || l2 != null) {
      int sum = 0;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      sum += carry;
      carry = sum / 10;// 몫
      curr.next = new ListNode(sum % 10); // 나머지
      curr = curr.next;
    }
    if (carry != 0) {
      curr.next = new ListNode(carry);
    }
    return dummyHead.next;
  }
}