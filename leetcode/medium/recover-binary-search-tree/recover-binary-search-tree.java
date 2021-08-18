/*
왼쪽 중간 오른쪽으로 탐색하면서 
틀린 값을 찾는데 이때, 틀린값이란 이전값보다 작은값이 틀른 닶이다, 

*/
public class Solution {

  TreeNode first = null, second = null, pre = null;

  public void recoverTree(TreeNode root) {
    if (root == null)
      return;
    dfs(root);
    if (first != null && second != null) {
      int temp = first.val;
      first.val = second.val;
      second.val = temp;
    }

  }

  public void dfs(TreeNode root) {
    if (root.left != null)
      dfs(root.left);
    if (pre != null && pre.val > root.val) {
      if (first == null) {
        first = pre;
      }
      second = root;
    }
    pre = root;
    if (root.right != null)
      dfs(root.right);
  }
}