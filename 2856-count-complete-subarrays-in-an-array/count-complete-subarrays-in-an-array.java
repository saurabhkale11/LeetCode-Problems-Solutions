import java.util.*;

public class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> distinctElements = new HashSet<>();
        
        // Step 1: Find the number of distinct elements in the entire array.
        for (int num : nums) {
            distinctElements.add(num);
        }
        int distinctCount = distinctElements.size();
        
        // Step 2: Use two pointers to find all complete subarrays.
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int start = 0, end = 0, result = 0;
        
        // Step 3: Slide the window with two pointers
        while (end < n) {
            // Include the current element
            frequencyMap.put(nums[end], frequencyMap.getOrDefault(nums[end], 0) + 1);
            
            // Move `end` pointer to the right
            while (frequencyMap.size() == distinctCount) {
                // If the current window contains all distinct elements, count all subarrays
                result += n - end;  // All subarrays starting from `start` to `end` and ending at `end` are valid
                
                // Shrink the window from the left
                frequencyMap.put(nums[start], frequencyMap.get(nums[start]) - 1);
                if (frequencyMap.get(nums[start]) == 0) {
                    frequencyMap.remove(nums[start]);
                }
                start++;
            }
            
            end++;
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 3, 1, 2, 2};
        System.out.println(sol.countCompleteSubarrays(nums1)); // Output: 4
        
        int[] nums2 = {5, 5, 5, 5};
        System.out.println(sol.countCompleteSubarrays(nums2)); // Output: 10
    }
}
