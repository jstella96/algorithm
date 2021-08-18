import java.util.*;

// Definition for a binary tree node.
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

class Solution {

  // 가장 크면서 가까운 후계자 찾기
  public TreeNode succ(TreeNode curr) {
    curr = curr.right;
    while (curr != null && curr.left != null) {
      curr = curr.left;
    }
    return curr;
  }

  // For deleting the node
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    } else if (root.val > key) {
      root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
      root.right = deleteNode(root.right, key);
    }

    // 루트 키 값이 삭제하도록 지정된 값과 일치하는 경우
    // root.val == key
    else {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else { // 양쪽이 다 차 있으면
        TreeNode succ = succ(root); // 후계자. 노드
        root.val = succ.val; // val은 후계자 노드의 val 이고.
        root.right = deleteNode(root.right, succ.val); //
      }
    }
    return root;
  }
}