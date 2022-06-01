# delete-node-in-a-bst

[문제링크](https://leetcode.com/problems/delete-node-in-a-bst/)

## 문제 설명

BST와 키의 루트 노드 참조가 주어지면 BST에서 주어진 키를 가진 노드를 삭제합니다. BST의 루트 노드 참조(업데이트될 수 있음)를 반환합니다. 기본적으로 삭제는 두 단계로 나눌 수 있습니다.

- 제거할 노드를 검색합니다.
- 노드가 발견되면 노드를 삭제합니다.

## 풀이 코드

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    // 가장 크면서 가까운 후계자 찾기
    public TreeNode succ(TreeNode curr){
        curr = curr.right;
        while( curr!=null && curr.left!=null ){
            curr = curr.left;
        }
        return curr;
    }

    // For deleting the node
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        else if(root.val>key){
            root.left = deleteNode(root.left, key);
        }
        else if(root.val<key){
            root.right = deleteNode(root.right, key);
        }

        // 루트 키 값이 삭제하도록 지정된 값과 일치하는 경우
        //root.val == key
        else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{ //양쪽이 다 차 있으면
                TreeNode succ = succ(root); //후계자. 노드
                root.val = succ.val;  // val은 후계자 노드의 val 이고.
                root.right = deleteNode(root.right, succ.val); //
            }
        }
        return root;
    }
}
```
