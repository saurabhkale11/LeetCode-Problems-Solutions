import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Step 1: Build the adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Step 2: DFS to find all connected components
        boolean[] visited = new boolean[n];
        int completeCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // Perform DFS to find all nodes in the connected component
                List<Integer> component = new ArrayList<>();
                dfs(i, graph, visited, component);
                
                // Step 3: Check if the component is complete
                if (isComplete(component, graph)) {
                    completeCount++;
                }
            }
        }

        return completeCount;
    }

    // DFS function to find the connected component
    private void dfs(int node, List<List<Integer>> graph, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }

    // Check if the component is complete
    private boolean isComplete(List<Integer> component, List<List<Integer>> graph) {
        int k = component.size();
        int expectedEdges = k * (k - 1) / 2; // For a complete graph with k nodes
        int actualEdges = 0;

        // Count the edges within this component
        Set<String> edgeSet = new HashSet<>();
        for (int node : component) {
            for (int neighbor : graph.get(node)) {
                if (component.contains(neighbor)) {
                    String edge = node < neighbor ? node + "-" + neighbor : neighbor + "-" + node;
                    edgeSet.add(edge);
                }
            }
        }

        actualEdges = edgeSet.size();
        return actualEdges == expectedEdges;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int n1 = 6;
        int[][] edges1 = {{0,1},{0,2},{1,2},{3,4}};
        System.out.println(sol.countCompleteComponents(n1, edges1)); // Output: 3

        // Example 2
        int n2 = 6;
        int[][] edges2 = {{0,1},{0,2},{1,2},{3,4},{3,5}};
        System.out.println(sol.countCompleteComponents(n2, edges2)); // Output: 1
    }
}
