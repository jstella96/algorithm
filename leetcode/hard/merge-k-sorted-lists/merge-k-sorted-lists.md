# merge-k-sorted-lists

## 스터디

- 우린 머지 솔트의 중간 결과물을 가지고 있기 때문에 !!!!!!!
- 머지솔트 나머지 구현. !
- listnode . 포인트만 알려준다.
- 포인트가 비어있지 않을때까지 .
- 싱글리스트 이해하고 있냐.
- 그냥 리스트있냐. 뼈대를 만드려면..
- 앞에 가상으로 만들었으니까. 아래서 next. 로

## 풀이 코드

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> numbers = new PriorityQueue<>((x, y) -> x - y);

        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while(node != null){
                numbers.offer(node.val);
                node = node.next;
            }
        }

        ListNode head = new ListNode(-1);
        ListNode node = head;

        while (0 < numbers.size()) {
            node.next = new ListNode(numbers.poll());
            node = node.next;
        }


        return head.next;

    }
}

```
