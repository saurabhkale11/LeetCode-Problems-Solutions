public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int result1 = solution.maxProfit(prices1);
        System.out.println(result1);  // Output: 5

        // Example 2
        int[] prices2 = {7, 6, 4, 3, 1};
        int result2 = solution.maxProfit(prices2);
        System.out.println(result2);  // Output: 0
    }
}
