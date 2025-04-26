class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int next = i + questions[i][1] + 1;
            if (next < n) dp[i] = Math.max(dp[i + 1], questions[i][0] + dp[next]);
            else dp[i] = Math.max(dp[i + 1], questions[i][0]);
        }
        return dp[0];
    }
}
