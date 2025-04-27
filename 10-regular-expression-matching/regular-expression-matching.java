public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // DP table where dp[i][j] means s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty string matches empty pattern
        dp[0][0] = true;
        
        // Handle patterns like "a*", "a*b*" where '*' can match zero occurrences
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                if (pc == sc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1]; // Match current characters
                } else if (pc == '*') {
                    // Zero occurrence of the character before '*'
                    dp[i][j] = dp[i][j - 2];
                    
                    // One or more occurrences of the character before '*'
                    if (sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}
