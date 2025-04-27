import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        
        // Iterate over the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements to avoid repeating the same triplet
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                // Check if we have found the closest sum
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                
                // Move pointers based on the comparison of sum and target
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum; // sum is exactly the target
                }
            }
        }
        
        return closestSum;
    }
}
