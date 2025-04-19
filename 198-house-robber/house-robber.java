public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        // Base cases
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        // Initialize DP array
        int dp0 = nums[0];  // dp[i-2]
        int dp1 = Math.max(nums[0], nums[1]);  // dp[i-1]
        
        for (int i = 2; i < n; i++) {
            int dp2 = Math.max(dp1, nums[i] + dp0);  // dp[i]
            dp0 = dp1;  // Update dp[i-2]
            dp1 = dp2;  // Update dp[i-1]
        }
        
        return dp1;  // The maximum money we can rob from all houses
    }
}
