public class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, maxLength = 1, currentAND = 0;

        for (int right = 0; right < nums.length; right++) {
            // If the current element causes the AND to become non-zero, move the left pointer
            while ((currentAND & nums[right]) != 0) {
                // Shrink the window from the left
                currentAND &= ~nums[left];
                left++;
            }
            
            // Add the current element to the AND
            currentAND |= nums[right];
            
            // Update the maxLength of the nice subarray
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
