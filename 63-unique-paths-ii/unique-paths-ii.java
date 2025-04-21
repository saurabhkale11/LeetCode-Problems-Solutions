public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // Create a DP table to store the number of ways to reach each cell
        int[][] dp = new int[m][n];

        // Base case: starting position (0, 0)
        if (obstacleGrid[0][0] == 1) {
            return 0; // If the start position has an obstacle, no path is possible
        }
        dp[0][0] = 1; // There's one way to reach the start position: starting there

        // Fill the first column
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0]; // If no obstacle, the only way is from the cell above
            }
        }

        // Fill the first row
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j - 1]; // If no obstacle, the only way is from the cell to the left
            }
        }

        // Fill the rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) { // Only compute if no obstacle
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // Sum ways from top and left
                }
            }
        }

        // The bottom-right corner contains the result
        return dp[m - 1][n - 1];
    }
}
