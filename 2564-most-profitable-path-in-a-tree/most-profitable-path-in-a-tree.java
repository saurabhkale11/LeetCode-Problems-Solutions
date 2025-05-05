import java.util.*;

public class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] bobTime;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;

        // Build tree
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }

        bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        findBobTime(bob, -1, 0);

        return dfsAlice(0, -1, 0, amount);
    }

    // Find the earliest time Bob reaches each node
    private boolean findBobTime(int node, int parent, int time) {
        if (node == 0) {
            bobTime[node] = time;
            return true;
        }

        for (int nei : graph.get(node)) {
            if (nei == parent) continue;
            if (findBobTime(nei, node, time + 1)) {
                bobTime[node] = time;
                return true;
            }
        }

        return false;
    }

    // DFS for Alice to maximize income
    private int dfsAlice(int node, int parent, int time, int[] amount) {
        int income;
        if (time < bobTime[node]) {
            income = amount[node];
        } else if (time == bobTime[node]) {
            income = amount[node] / 2;
        } else {
            income = 0;
        }

        int maxChildIncome = Integer.MIN_VALUE;
        for (int nei : graph.get(node)) {
            if (nei == parent) continue;
            maxChildIncome = Math.max(maxChildIncome, dfsAlice(nei, node, time + 1, amount));
        }

        return maxChildIncome == Integer.MIN_VALUE ? income : income + maxChildIncome;
    }
}
