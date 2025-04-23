class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        
        int m = board.length;
        int n = board[0].length;
        
        // DFS function to mark all 'O's connected to the border
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Check border 'O's
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        
        // Now, change all remaining 'O's to 'X' and all 'T's back to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';  // Capture surrounded region
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';  // Revert back to 'O' for border-connected regions
                }
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j) {
        // Check bounds and if it's an 'O'
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        
        // Mark the current 'O' as visited (Temporary mark 'T')
        board[i][j] = 'T';
        
        // Explore all 4 directions
        dfs(board, i + 1, j); // Down
        dfs(board, i - 1, j); // Up
        dfs(board, i, j + 1); // Right
        dfs(board, i, j - 1); // Left
    }
}
