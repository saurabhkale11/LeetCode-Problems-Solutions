public class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Arrays to keep track of the number of servers in each row and column
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        
        // Calculate the row and column server counts
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        
        // Count the number of servers that can communicate with others
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // A server can communicate if there's more than one server in its row or column
                    if (rowCount[i] > 1 || colCount[j] > 1) {
                        result++;
                    }
                }
            }
        }
        
        return result;
    }
}
