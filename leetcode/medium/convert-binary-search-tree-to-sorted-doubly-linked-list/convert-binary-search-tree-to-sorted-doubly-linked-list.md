# convert-binary-search-tree-to-sorted-doubly-linked-list


[문제링크](https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/)

## 문제 설명

이진 검색 트리를 Sorted Doubly Linked List으로 변환해라. 


## 풀이 코드

```java
class Solution {
    Node prev;
    public Node treeToDoublyList(Node root) {

        if (root == null)
            return null;
        prev = new Node(0, null, null);
        Node temp = prev;
        helper(root);
        System.out.println( temp.right.val);
        prev.right = temp.right;
        temp.right.left = prev;
        return temp.right;
    }

    private void helper(Node root){
        if (root == null)
            return;
        helper(root.left);
        prev.right = root;
        root.left = prev;
        prev = root;
        helper(root.right);
    }
}

```
