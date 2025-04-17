public class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int maxLength = 0;
        int zeroCount = 0;

        while (right < nums.length) {
            // Expand the window by moving the right pointer
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If the zero count exceeds k, shrink the window by moving the left pointer
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Calculate the maximum length of subarray
            maxLength = Math.max(maxLength, right - left + 1);

            // Move the right pointer forward
            right++;
        }

        return maxLength;
    }
}
