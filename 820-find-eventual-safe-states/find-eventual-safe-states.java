import java.util.*;

public class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        int[] outDegree = new int[n];

        for (int i = 0; i < n; i++) reverseGraph.add(new ArrayList<>());

        for (int u = 0; u < n; u++) {
            outDegree[u] = graph[u].length;
            for (int v : graph[u]) {
                reverseGraph.get(v).add(u);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 0) queue.offer(i);
        }

        boolean[] safe = new boolean[n];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safe[node] = true;
            for (int neighbor : reverseGraph.get(node)) {
                outDegree[neighbor]--;
                if (outDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) result.add(i);
        }

        return result;
    }
}
