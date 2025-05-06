public class Solution {
    public int[] applyOperations(int[] nums) {
        // Apply operations
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // Move zeros to the end
        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }
        }
        
        // Fill remaining positions with 0
        for (int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }

        return nums;
    }
}
