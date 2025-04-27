import java.util.*;

public class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] marked = new boolean[n];
        long score = 0; // Change the score to long to handle larger sums

        // Create a list of pairs (value, index)
        List<int[]> indexedNums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indexedNums.add(new int[] {nums[i], i});
        }

        // Sort the list by the value, then by index (in case of tie)
        Collections.sort(indexedNums, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // Iterate over the sorted list and calculate score
        for (int[] pair : indexedNums) {
            int value = pair[0];
            int index = pair[1];

            // If the current element is already marked, skip it
            if (marked[index]) continue;

            // Add the value to the score
            score += value;

            // Mark the current element
            marked[index] = true;

            // Mark the left adjacent element if exists
            if (index - 1 >= 0) marked[index - 1] = true;

            // Mark the right adjacent element if exists
            if (index + 1 < n) marked[index + 1] = true;
        }

        return score;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {2,1,3,4,5,2};
        int[] nums2 = {2,3,5,1,3,2};
        
        System.out.println(sol.findScore(nums1)); // Expected output: 7
        System.out.println(sol.findScore(nums2)); // Expected output: 5
    }
}
