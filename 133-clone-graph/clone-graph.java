import java.util.*;

public class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // HashMap to store the mapping between original node and its clone
        Map<Node, Node> visited = new HashMap<>();
        
        // Helper function for DFS traversal and cloning
        return dfs(node, visited);
    }

    private Node dfs(Node node, Map<Node, Node> visited) {
        // If the node has already been cloned, return its clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a clone for the current node
        Node clone = new Node(node.val);
        visited.put(node, clone);  // Map the original node to the cloned node
        
        // Recursively clone all the neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, visited));
        }

        return clone;
    }
}
