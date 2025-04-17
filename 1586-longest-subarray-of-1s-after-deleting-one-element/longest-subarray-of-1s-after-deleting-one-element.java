public class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, right = 0;
        int zeroCount = 0;
        int maxLength = 0;

        while (right < nums.length) {
            // Expand the window by moving the right pointer
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If there are more than one zero, shrink the window from the left
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update the maxLength. We subtract 1 because we must delete one element.
            maxLength = Math.max(maxLength, right - left);
            right++;
        }

        return maxLength;
    }
}
