public class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 0;
        
        // Find the maximum number of balls in any bag
        for (int num : nums) {
            right = Math.max(right, num);
        }

        // Binary search to find the minimum maximum bag size
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isPossible(nums, mid, maxOperations)) {
                right = mid; // Try to minimize the maximum bag size
            } else {
                left = mid + 1; // Increase the bag size
            }
        }

        return left;
    }

    private boolean isPossible(int[] nums, int maxBagSize, int maxOperations) {
        int operations = 0;
        
        // For each bag, calculate how many splits are needed to make each sub-bag <= maxBagSize
        for (int num : nums) {
            if (num > maxBagSize) {
                operations += (num - 1) / maxBagSize; // (num - 1) / maxBagSize gives the number of splits
            }
        }

        // If we need more operations than allowed, return false
        return operations <= maxOperations;
    }
}
