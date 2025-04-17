import java.util.*;

public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Convert nums1 and nums2 to sets to get distinct elements
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        // Add elements of nums1 and nums2 to their respective sets
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        
        // Find elements in nums1 not in nums2
        List<Integer> result1 = new ArrayList<>();
        for (int num : set1) {
            if (!set2.contains(num)) {
                result1.add(num);
            }
        }
        
        // Find elements in nums2 not in nums1
        List<Integer> result2 = new ArrayList<>();
        for (int num : set2) {
            if (!set1.contains(num)) {
                result2.add(num);
            }
        }
        
        // Prepare the final result as a list of two lists
        List<List<Integer>> result = new ArrayList<>();
        result.add(result1);
        result.add(result2);
        
        return result;
    }
}
