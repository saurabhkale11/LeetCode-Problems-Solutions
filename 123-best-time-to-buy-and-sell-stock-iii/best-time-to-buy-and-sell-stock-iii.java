public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        
        int n = prices.length;
        
        // dp[k][i] will represent the maximum profit up to day i with k transactions
        int[][] dp = new int[3][n];
        
        // We have two transaction cases, k = 1 and k = 2
        for (int k = 1; k <= 2; k++) {
            int maxDiff = -prices[0];  // stores the maximum value of dp[k-1][i] - prices[i]
            
            for (int i = 1; i < n; i++) {
                dp[k][i] = Math.max(dp[k][i-1], prices[i] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[k-1][i] - prices[i]);
            }
        }
        
        return dp[2][n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] prices1 = {3,3,5,0,0,3,1,4};
        int result1 = solution.maxProfit(prices1);
        System.out.println(result1);  // Output: 6
        
        int[] prices2 = {1,2,3,4,5};
        int result2 = solution.maxProfit(prices2);
        System.out.println(result2);  // Output: 4
        
        int[] prices3 = {7,6,4,3,1};
        int result3 = solution.maxProfit(prices3);
        System.out.println(result3);  // Output: 0
    }
}
