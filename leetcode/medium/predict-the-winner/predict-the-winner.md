# predict The Winner

## 문제

integer array `nums`가 주어진다. player1, player2는 이 array로 게임을한다.
선수는 번갈아 가면서 turn을 가지고 시작은 player1이 한다 두명의 플레이어는 socre 0 에서 시작하고 각자의 턴에
nums[0] , nums[nums.length-1] 중 하나를 가져와 자신의 score에 더할 수 있다. array가 비면 게임은 끝난다.
만약 점수가 plater1 >= player2면 true를 return 해라.
모든 선택에서 플레이어들은 최적의 플레이를 하고 있다고 가정한다.

## 문제 풀이

P1 - p2 >= 0 인지 확인해야한다. player1일때는 이차이를 최대로 player2일때는 이 차이를 최소로한다고 생각하여야 한다.

## 풀이 코드

```java
class Solution {

    public boolean PredictTheWinner(int[] nums) {
        return dfs(0, nums.length - 1, 0, nums, true) >= 0;
    }

    public int dfs(int start, int end, int p1, int[] nums, boolean p1Turn) {

        if (start > end)
            return p1;

        if (p1Turn) {
            int bottom = dfs(start + 1, end, p1 + nums[start], nums, false);
            int top = dfs(start, end - 1, p1 + nums[end], nums, false);


            return Math.max(top, bottom);
        } else {
            int bottom = dfs(start + 1, end, p1 - nums[start], nums, true);
            int top = dfs(start, end - 1, p1 - nums[end], nums, true);
            return Math.min(bottom, top);
        }
    }
}
```
