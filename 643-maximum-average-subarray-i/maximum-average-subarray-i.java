public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Find the sum of the first 'k' elements
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // Initialize the maximum average to the average of the first 'k' elements
        double maxAvg = sum / k;

        // Use a sliding window to calculate the sum of all subarrays of length 'k'
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxAvg = Math.max(maxAvg, sum / k);
        }

        return maxAvg;
    }
}
