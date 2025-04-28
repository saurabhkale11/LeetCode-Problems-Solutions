class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int numIslands = 0;
        
        // Iterate through each cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If we find a '1', that means a new island is found
                if (grid[i][j] == '1') {
                    numIslands++;
                    // Start DFS to mark the entire island
                    dfs(grid, i, j, m, n);
                }
            }
        }
        
        return numIslands;
    }
    
    // DFS to mark all connected '1's as visited (turn them into '0')
    private void dfs(char[][] grid, int i, int j, int m, int n) {
        // Check boundaries and if the cell is water or already visited
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        
        // Mark the cell as visited
        grid[i][j] = '0';
        
        // Explore all 4 possible directions (up, down, left, right)
        dfs(grid, i + 1, j, m, n);  // down
        dfs(grid, i - 1, j, m, n);  // up
        dfs(grid, i, j + 1, m, n);  // right
        dfs(grid, i, j - 1, m, n);  // left
    }
}
