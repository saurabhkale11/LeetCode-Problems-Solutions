public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m + 1][n + 1];

        // Initialize base cases
        for (int i = 0; i <= m; i++) dp[i][0] = i; // Deleting all characters from word1
        for (int j = 0; j <= n; j++) dp[0][j] = j; // Inserting all characters into word1

        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // No operation needed if characters are the same
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Take the minimum of three possible operations
                    dp[i][j] = Math.min(
                        dp[i - 1][j - 1], // Replace character
                        Math.min(dp[i - 1][j], dp[i][j - 1]) // Delete or Insert
                    ) + 1;
                }
            }
        }

        return dp[m][n];
    }
}
