class Solution {
    public int minCut(String s) {
        int n = s.length();
        if (n <= 1) return 0;

        // dp[i] represents the minimum cuts needed for substring s[0..i]
        int[] dp = new int[n];
        
        // isPalindrome[i][j] will be true if s[i..j] is a palindrome
        boolean[][] isPalindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i] = i; // Maximum cuts possible: cut between each character

            for (int j = 0; j <= i; j++) {
                // Check if substring s[j..i] is a palindrome
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;

                    // If it's a palindrome, we may not need a cut between j and i
                    if (j == 0) {
                        dp[i] = 0; // No cuts needed if the whole substring is a palindrome
                    } else {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1); // One more cut
                    }
                }
            }
        }
        
        return dp[n - 1];
    }
}
