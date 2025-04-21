public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int i, int j, int index) {
        // Check if the current position is out of bounds or the character doesn't match
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // If we have reached the end of the word
        if (index == word.length() - 1) {
            return true;
        }

        // Mark the current cell as visited by replacing the character with a placeholder
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore all four possible directions: up, down, left, right
        boolean found = backtrack(board, word, i + 1, j, index + 1) ||
                        backtrack(board, word, i - 1, j, index + 1) ||
                        backtrack(board, word, i, j + 1, index + 1) ||
                        backtrack(board, word, i, j - 1, index + 1);

        // Restore the original character (backtrack)
        board[i][j] = temp;

        return found;
    }
}
