import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maximumBeauty(int[] nums, int k) {
        // Sort the array to use a sliding window
        java.util.Arrays.sort(nums);
        
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxBeauty = 1; // At least one element is always a valid subsequence
        
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            // For each target number nums[right], try to make everything within the window [left, right] equal to nums[right]
            while (nums[right] - nums[left] > 2 * k) {
                left++;
            }
            
            // Update the beauty (longest subsequence)
            maxBeauty = Math.max(maxBeauty, right - left + 1);
        }
        
        return maxBeauty;
    }
}
