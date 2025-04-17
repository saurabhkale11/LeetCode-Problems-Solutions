public class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0;
        
        // Move non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex++] = nums[i];
            }
        }
        
        // Fill the remaining elements with 0's
        for (int i = lastNonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
