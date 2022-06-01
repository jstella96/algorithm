# merge-k-sorted-lists

[문제링크](https://leetcode.com/problems/merge-k-sorted-lists/)

## 문제 설명

linked-lists `lists`가 주어질 때, 각 linked-list는 오름차순으로 정렬된다. 모든 연결 목록을 하나의 정렬된 연결 목록으로 병합하고 반환해라

## 입출력 예시

```
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
```

## 문제 풀이

그냥 풀어서 다시만들면 쉽게 만들어진다. 모든 리스트를 분해한 후 PriorityQueue에 넣으면 자동 정렬되고, 다시 list구조를 만든다.

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

        //1.분해
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            while(node != null){
                numbers.offer(node.val);
                node = node.next;
            }
        }
        //2.재조립
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
