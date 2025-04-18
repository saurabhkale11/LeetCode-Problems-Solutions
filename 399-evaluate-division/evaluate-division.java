import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Step 1: Build the graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        // Populate the graph with edges (variables and the corresponding values)
        for (int i = 0; i < equations.size(); i++) {
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);
            double value = values[i];
            
            graph.putIfAbsent(var1, new HashMap<>());
            graph.putIfAbsent(var2, new HashMap<>());
            
            graph.get(var1).put(var2, value);
            graph.get(var2).put(var1, 1 / value);
        }
        
        // Step 2: Process each query
        double[] result = new double[queries.size()];
        
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            
            // If either start or end variable is not in the graph, the answer is -1.0
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0;
            } else {
                // Perform DFS to find the path and calculate the result
                Set<String> visited = new HashSet<>();
                result[i] = dfs(graph, start, end, visited);
            }
        }
        
        return result;
    }
    
    // DFS to find the value from start to end
    private double dfs(Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited) {
        if (start.equals(end)) {
            return 1.0;
        }
        
        visited.add(start);
        
        Map<String, Double> neighbors = graph.get(start);
        for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
            String neighbor = entry.getKey();
            double value = entry.getValue();
            
            if (!visited.contains(neighbor)) {
                double result = dfs(graph, neighbor, end, visited);
                if (result != -1.0) {
                    return result * value;
                }
            }
        }
        
        return -1.0;
    }
}
