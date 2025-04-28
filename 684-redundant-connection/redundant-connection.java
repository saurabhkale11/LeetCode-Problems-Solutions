public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1);  // We use n + 1 to accommodate 1-indexing

        // Traverse edges in the input order
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];

            if (uf.find(u) == uf.find(v)) {
                // If u and v are already connected, this is the redundant edge
                return edge;
            }
            uf.union(u, v);
        }

        // If no cycle is found (shouldn't happen as we know one edge creates a cycle)
        return new int[]{};
    }

    // Union-Find data structure
    class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        // Find operation with path compression
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);  // Path compression
            }
            return parent[x];
        }

        // Union operation
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                parent[rootX] = rootY;  // Union the two components
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[][] edges1 = {{1,2},{1,3},{2,3}};
        int[] result1 = sol.findRedundantConnection(edges1);
        System.out.println("Redundant edge: [" + result1[0] + "," + result1[1] + "]"); // Expected: [2,3]

        // Example 2
        int[][] edges2 = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] result2 = sol.findRedundantConnection(edges2);
        System.out.println("Redundant edge: [" + result2[0] + "," + result2[1] + "]"); // Expected: [1,4]
    }
}
