public class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // DP table where dp[i][j] represents the number of distinct subsequences of s[0..i-1] that match t[0..j-1]
        int[][] dp = new int[m + 1][n + 1];
        
        // Base case: An empty string t can be matched by any prefix of s in exactly one way (by deleting all characters)
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // If characters match, we can either:
                    // 1. Include the current character of s, or
                    // 2. Exclude it
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // If characters don't match, we can only exclude the current character of s
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        // The answer is stored in dp[m][n]
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        String s1 = "rabbbit";
        String t1 = "rabbit";
        System.out.println(solution.numDistinct(s1, t1));  // Output: 3

        // Test case 2
        String s2 = "babgbag";
        String t2 = "bag";
        System.out.println(solution.numDistinct(s2, t2));  // Output: 5
    }
}
