public class Solution {
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long target = 1;  // The first number we want to form
        int i = 0;
        int len = nums.length;
        
        // Loop until we can form numbers from 1 to n
        while (target <= n) {
            if (i < len && nums[i] <= target) {
                // If the current number is <= target, we can extend the range
                target += nums[i++];
            } else {
                // If the current number is > target, we need to add a patch
                target += target;
                patches++;
            }
        }
        
        return patches;
    }
}
