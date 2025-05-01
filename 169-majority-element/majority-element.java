public class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        
        // Step 1: Find the candidate
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        // Step 2: The majority element is guaranteed to exist
        return candidate;
    }
}
