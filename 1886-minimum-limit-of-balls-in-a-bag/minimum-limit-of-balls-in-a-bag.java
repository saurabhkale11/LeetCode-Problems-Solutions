public class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = 0;
        
        // Find the maximum size of any bag
        for (int num : nums) {
            high = Math.max(high, num);
        }
        
        // Binary search on the maximum size of a bag after operations
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canDivide(nums, mid, maxOperations)) {
                high = mid;  // Try for a smaller max size
            } else {
                low = mid + 1;  // Increase the max size
            }
        }
        
        return low;  // The smallest max size that works
    }
    
    // Helper function to check if it's possible to make all bags <= maxSize with maxOperations
    private boolean canDivide(int[] nums, int maxSize, int maxOperations) {
        int operations = 0;
        
        // For each bag, calculate the number of splits needed
        for (int num : nums) {
            if (num > maxSize) {
                operations += (num - 1) / maxSize;  // Number of splits required for this bag
            }
            if (operations > maxOperations) {
                return false;  // If we exceed max operations, return false
            }
        }
        
        return true;
    }
}
