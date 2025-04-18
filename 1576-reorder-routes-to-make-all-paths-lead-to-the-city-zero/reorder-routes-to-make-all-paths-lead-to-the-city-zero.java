import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        // Step 1: Create the adjacency list representation of the graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Fill the graph with roads and their directions
        for (int[] conn : connections) {
            graph.get(conn[0]).add(new int[]{conn[1], 1}); // 1 indicates the direction from conn[0] to conn[1]
            graph.get(conn[1]).add(new int[]{conn[0], 0}); // 0 indicates the opposite direction from conn[1] to conn[0]
        }
        
        // Step 2: Perform DFS from city 0 and count how many roads need to be reversed
        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }
    
    // DFS helper function
    private int dfs(int node, List<List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int changes = 0;
        
        // Visit all neighbors of the current city
        for (int[] neighbor : graph.get(node)) {
            int neighborCity = neighbor[0];
            int roadDirection = neighbor[1]; // 1 if road is directed from node to neighbor, 0 if from neighbor to node
            
            if (!visited[neighborCity]) {
                // If the road is directed away from node, we need to change it
                if (roadDirection == 1) {
                    changes++;
                }
                // Continue DFS to the next city
                changes += dfs(neighborCity, graph, visited);
            }
        }
        
        return changes;
    }
}
