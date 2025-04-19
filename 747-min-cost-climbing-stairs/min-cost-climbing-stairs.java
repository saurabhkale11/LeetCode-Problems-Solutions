public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // Base cases
        int dp0 = cost[0];  // dp[i-2]
        int dp1 = cost[1];  // dp[i-1]
        
        for (int i = 2; i < n; i++) {
            int dp2 = Math.min(dp0, dp1) + cost[i];  // dp[i]
            dp0 = dp1;  // move dp[i-2] to dp[i-1]
            dp1 = dp2;  // move dp[i-1] to dp[i]
        }
        
        return Math.min(dp0, dp1);  // The minimum cost to reach the top
    }
}
