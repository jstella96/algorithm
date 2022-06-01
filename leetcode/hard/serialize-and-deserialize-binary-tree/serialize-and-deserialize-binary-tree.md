# serialize-and-deserialize-binary-tree


[문제링크](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)

## 문제 설명

직렬화는 데이터 구조 또는 개체를 비트 시퀀스로 변환하여 파일 또는 메모리 버퍼에 저장하거나 네트워크 연결 링크를 통해 전송하여 나중에 동일하거나 다른 컴퓨터 환경에서 재구성하는 프로세스입니다. 이진 트리를 직렬화 및 역직렬화하는 알고리즘을 설계합니다. 직렬화/역직렬화 알고리즘이 작동하는 방식에는 제한이 없습니다. 이진 트리를 문자열로 직렬화할 수 있고 이 문자열을 원래 트리 구조로 역직렬화할 수 있는지 확인하기만 하면 됩니다.

## 문제 풀이

queue를 사용해 작업해야하는 노드를 순차적으로 넣어놓고,
작업결과로 result만든다. 디코딩시에 큐에 넣은거 다시 원상복구 한다.

## 풀이 코드

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }

    private TreeNode helper(Queue<String> queue) {
        String s = queue.poll();
        if (s.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}
```
