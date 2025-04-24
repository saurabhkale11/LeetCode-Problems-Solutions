import java.util.*;

public class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Deque<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();

        for (int[] pair : pairs) {
            graph.computeIfAbsent(pair[0], x -> new ArrayDeque<>()).add(pair[1]);
            outdegree.put(pair[0], outdegree.getOrDefault(pair[0], 0) + 1);
            indegree.put(pair[1], indegree.getOrDefault(pair[1], 0) + 1);
        }

        int start = pairs[0][0];
        for (int key : graph.keySet()) {
            if (outdegree.getOrDefault(key, 0) - indegree.getOrDefault(key, 0) == 1) {
                start = key;
                break;
            }
        }

        List<int[]> result = new ArrayList<>();
        dfs(graph, start, result);
        Collections.reverse(result);

        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    private void dfs(Map<Integer, Deque<Integer>> graph, int u, List<int[]> res) {
        Deque<Integer> neighbors = graph.get(u);
        while (neighbors != null && !neighbors.isEmpty()) {
            int v = neighbors.poll();
            dfs(graph, v, res);
            res.add(new int[]{u, v});
        }
    }
}
