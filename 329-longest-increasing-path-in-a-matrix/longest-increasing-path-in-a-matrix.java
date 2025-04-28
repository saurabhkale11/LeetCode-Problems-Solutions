public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];  // Memoization table

        int longestPath = 0;

        // Directions for moving up, down, left, and right
        int[] directions = {-1, 0, 1, 0, -1, 0};

        // DFS helper function
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                longestPath = Math.max(longestPath, dfs(matrix, memo, i, j, m, n, directions));
            }
        }

        return longestPath;
    }

    // DFS function to find the longest increasing path starting from cell (i, j)
    private int dfs(int[][] matrix, int[][] memo, int i, int j, int m, int n, int[] directions) {
        // If the result is already computed, return it
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        // Initialize the longest path length for this cell to 1 (itself)
        int longest = 1;

        // Explore all 4 directions (up, down, left, right)
        for (int d = 0; d < 4; d++) {
            int newI = i + directions[d];
            int newJ = j + directions[d + 1];

            // Check if the new position is within bounds and the value is greater than the current one
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && matrix[newI][newJ] > matrix[i][j]) {
                longest = Math.max(longest, 1 + dfs(matrix, memo, newI, newJ, m, n, directions));
            }
        }

        // Memoize the result for the current cell
        memo[i][j] = longest;

        return longest;
    }
}
