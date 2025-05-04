public class Solution {
    public int minCapability(int[] nums, int k) {
        int low = 1, high = Integer.MAX_VALUE;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canRob(nums, mid, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }

    private boolean canRob(int[] nums, int capability, int k) {
        int count = 0;
        int i = 0;
        
        while (i < nums.length) {
            if (nums[i] <= capability) {
                count++;
                i += 2;  // Skip the next house to avoid adjacent robbery
            } else {
                i++;
            }
        }
        
        return count >= k;
    }
}
