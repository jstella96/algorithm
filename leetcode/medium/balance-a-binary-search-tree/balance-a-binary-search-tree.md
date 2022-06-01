# balance-a-binary-search-tree


[문제링크](https://leetcode.com/problems/balance-a-binary-search-tree/)

## 문제 설명

이진 탐색 트리의 루트가 주어지면 동일한 노드 값을 가진 균형 이진 탐색 트리를 반환합니다. 답변이 둘 이상인 경우 그 중 하나를 반환하십시오. 모든 노드의 두 하위 트리의 깊이가 1 이상 차이가 나지 않으면 이진 탐색 트리가 균형을 이룹니다.

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
    List<TreeNode> ls=new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
     inorder_traversal(root);
     return helper_balancedBST(ls,0,ls.size()-1);
    }
    public void inorder_traversal(TreeNode root){
        if(root==null)
            return;
        inorder_traversal(root.left);
        ls.add(root);
        inorder_traversal(root.right);
    }
    public TreeNode helper_balancedBST(List<TreeNode> nums,int start,int end){
        if(start>end)
            return null;
        int mid=(start+end)/2;
        TreeNode root=nums.get(mid);
        root.left=helper_balancedBST(nums,start,mid-1);
        root.right=helper_balancedBST(nums,mid+1,end);
        return root;
    }
}
```
