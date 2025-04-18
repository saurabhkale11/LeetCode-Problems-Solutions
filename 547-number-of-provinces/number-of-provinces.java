class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        // Iterate over all cities
        for (int i = 0; i < n; i++) {
            // If city i is not visited, it means it is a new province
            if (!visited[i]) {
                dfs(isConnected, visited, i, n);
                provinces++;
            }
        }
        return provinces;
    }

    // Depth-First Search to mark all cities connected to city i
    private void dfs(int[][] isConnected, boolean[] visited, int i, int n) {
        visited[i] = true;
        
        // Explore all cities connected to city i
        for (int j = 0; j < n; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j, n); // Visit the connected city
            }
        }
    }
}
