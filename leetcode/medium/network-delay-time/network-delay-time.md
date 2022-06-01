# network-delay-time

[문제링크](https://leetcode.com/problems/network-delay-time/)

## 문제 설명

모든 노드들이 네트워크로 나타내져 있고
각 노드들의 연결 비용을 나타낸 배열 `times[i] = (ui, vi, wi)` 가 주어진다.
시작 노드 `k` 와 모든 노드의 개수 `n`이 주어질 때
k부터 시작하여 n개의 모든 노드가 신호를 수신하는 데 걸리는 시간을 반환합니다.  
 n개의 모든 노드가 신호를 수신하는 것이 불가능하면 -1을 반환합니다.

## 입출력 예시

```
Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
```

## 문제 풀이

다익스트라로 모든 노드의 최단거리 구하고 그중 최대값을 구한다.
시작점 k에서 모든 노드까지의 최단거리를 구해주어야 하는 문제이다. 엣지에 음수값이 없고 최단거리 문제 이므로 다익스트라 알고리즘을 활용해서 풀 수 있다. dist에 각 노드 까지의 최단거리를 담고 마지막에 가장 큰 값을 return 한다. 만약 마지막에 dist의 갯수가 n보다 작다면 모든 노드에 신호를 보낼 수 없는 경우이므로 -1을 리턴한다.

## 풀이 코드

```java

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                (o1, o2) -> o1[0] - o2[0]);
        heap.offer(new int[]{0, K});

        Map<Integer, Integer> dist = new HashMap();

        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int d = info[0], node = info[1];
            if (dist.containsKey(node)) continue;
            dist.put(node, d);
            if (graph.containsKey(node))
                for (int[] edge: graph.get(node)) {
                    int nei = edge[0], d2 = edge[1];
                    if (!dist.containsKey(nei))
                        heap.offer(new int[]{d+d2, nei});
                }
        }

        if (dist.size() != N) return -1;
        int ans = 0;
        for (int cand: dist.values())
            ans = Math.max(ans, cand);
        return ans;
    }
}
```
