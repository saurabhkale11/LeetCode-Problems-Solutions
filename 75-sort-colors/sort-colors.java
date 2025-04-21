public class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Swap nums[low] and nums[mid], move both pointers
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                // If it's 1, just move the mid pointer
                mid++;
            } else {
                // Swap nums[mid] and nums[high], move high pointer
                swap(nums, mid, high--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
