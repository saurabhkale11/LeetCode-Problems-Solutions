public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        // Iterate through the prices array
        for (int i = 1; i < prices.length; i++) {
            // If the price of the next day is higher than the current day, we make a profit
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int result1 = solution.maxProfit(prices1);
        System.out.println(result1);  // Output: 7

        // Example 2
        int[] prices2 = {1, 2, 3, 4, 5};
        int result2 = solution.maxProfit(prices2);
        System.out.println(result2);  // Output: 4

        // Example 3
        int[] prices3 = {7, 6, 4, 3, 1};
        int result3 = solution.maxProfit(prices3);
        System.out.println(result3);  // Output: 0
    }
}
