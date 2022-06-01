# longest-increasing-path-in-a-matrix

[문제링크](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/)

## 문제 설명

m x n 정수 행렬이 주어지면 행렬에서 가장 긴 증가 경로의 길이를 반환합니다. 각 셀에서 왼쪽, 오른쪽, 위 또는 아래의 네 가지 방향으로 이동할 수 있습니다. 대각선으로 이동하거나 경계 밖으로 이동할 수 없습니다(즉, wrap-around는 허용되지 않음).

## 문제 예시

```
Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
```

## 문제 풀이

dfs: 가짓수를 다 계산해서 끝 값을 반환한다.
memo을 이용해서 그 지점에서 갈 수 있는 최대 값을 저장한다.

## 풀이 코드

```java
class Solution {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, memo);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] memo) {
        if(memo[i][j] != 0) return memo[i][j];
        int max = 1;
        for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, m, n, memo);
            max = Math.max(max, len);
        }
        memo[i][j] = max;
        return max;
    }
}
```
