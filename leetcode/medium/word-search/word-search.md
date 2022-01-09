# Word Search

## 문제

m x n개의 문자 `board`와 문자열 `word`가 주어진 경우, 격자에 word가 있으면 true를 반환합니다.

사방으로 인접한 문자열만 이어질 수 있습니다.

## 문제 풀이

## 풀이 코드

```java
public class Solution {
  boolean[][] visited;

  public boolean exist(char[][] board, String word) {
    if (word.length() == 0)
      return true;

    int row = board.length;
    int col = board[0].length;
    visited = new boolean[row][col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (search(board, word, 0, i, j))
          return true;
      }
    }
    return false;
  }

  boolean search(char[][] board, String word, int n, int i, int j) {// n : word의 인덱스
    if (n == word.length())
      return true; // 끝까지 돌았으면 .
    // 끝점이면
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
      return false;
    // 이미 방문했으면
    if (visited[i][j])
      return false;
    // 다르면
    if (word.charAt(n) != board[i][j])
      return false;

    // 일치하는 칸을 찾은 경우
    visited[i][j] = true;
    boolean result = search(board, word, n + 1, i - 1, j) || search(board, word, n + 1, i + 1, j)
        || search(board, word, n + 1, i, j - 1) || search(board, word, n + 1, i, j + 1);
    // 만약 연속된 연산에서 word를 찾지 못하면 해당 칸을 다시 계산해야하므로 false로 갱신해준다.
    if (result != true)
      visited[i][j] = false;
    return result;
  }

}
```
