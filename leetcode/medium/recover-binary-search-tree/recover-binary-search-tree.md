# recover-binary-search-tree


[문제링크](https://leetcode.com/problems/recover-binary-search-tree/)

## 문제 설명

BST(이진 검색 트리)의 루트가 제공되며 트리의 정확히 두 노드 값이 실수로 교환되었습니다. 구조를 변경하지 않고 트리를 복구하시오.

## 문제 풀이

왼쪽 중간 오른쪽으로 탐색하면서
틀린 값을 찾는데 이때, 틀린값이란 이전값보다 작은값이 틀린 값이다.

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

public class Solution {

    TreeNode first = null, second = null, pre = null;
    public void recoverTree(TreeNode root) {
        if(root==null)return;
        dfs(root);
        if(first!=null&&second!=null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

    }
    public void dfs(TreeNode root){
        if(root.left!=null)dfs(root.left);
        if(pre!=null&&pre.val>root.val)
            {
                if(first==null){
                    first = pre;
                }
                second = root;
            }
        pre = root;
        if(root.right!=null)dfs(root.right);
    }
}
```
