import java.util.HashMap;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Check if the number already exists in the map and its index difference is <= k
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            
            // Update the map with the current index
            map.put(nums[i], i);
        }
        
        // No duplicates found within the given range k
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test case 1
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        System.out.println(sol.containsNearbyDuplicate(nums1, k1));  // Output: true
        
        // Test case 2
        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println(sol.containsNearbyDuplicate(nums2, k2));  // Output: true
        
        // Test case 3
        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println(sol.containsNearbyDuplicate(nums3, k3));  // Output: false
    }
}
