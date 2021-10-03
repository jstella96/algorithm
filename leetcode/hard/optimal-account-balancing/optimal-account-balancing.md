```java
class Solution {
    public int minTransfers(int[][] transactions) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] trans : transactions) {
            map.put(trans[0], map.getOrDefault(trans[0], 0) - trans[2]);
            map.put(trans[1], map.getOrDefault(trans[1], 0) + trans[2]);
        }

        int n = map.size(), i = 0;
        int[] balence = new int[n];
        for (int k : map.keySet()) {
            balence[i++] = map.get(k);
        }

        return dfs(0, balence);
    }

    private int dfs(int idx, int[] balence) {
        if (idx == balence.length) return 0;
        if (balence[idx] == 0) return dfs(idx + 1, balence);
        int res = Integer.MAX_VALUE;

        int currDebt = balence[idx];

        for (int i = idx+1; i < balence.length; i++) {

            if (balence[i] * currDebt >= 0) continue;

            balence[i] += currDebt;
            res = Math.min(res, 1 + dfs(idx + 1, balence));
            balence[i] -= currDebt;


        }
        return res;
    }
}

```
