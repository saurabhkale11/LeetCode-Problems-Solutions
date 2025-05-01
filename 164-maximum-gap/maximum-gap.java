import java.util.*;

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        
        int min_val = Integer.MAX_VALUE;
        int max_val = Integer.MIN_VALUE;
        
        // Find the min and max values in the array
        for (int num : nums) {
            min_val = Math.min(min_val, num);
            max_val = Math.max(max_val, num);
        }
        
        // If the max and min values are the same, no gap exists
        if (max_val == min_val) return 0;
        
        // Calculate bucket size and number of buckets
        int n = nums.length;
        int bucketSize = Math.max(1, (max_val - min_val) / (n - 1)); // Ensure at least 1 element per bucket
        int bucketCount = (max_val - min_val) / bucketSize + 1;
        
        // Create buckets for min and max values
        int[] minBuckets = new int[bucketCount];
        int[] maxBuckets = new int[bucketCount];
        Arrays.fill(minBuckets, Integer.MAX_VALUE);
        Arrays.fill(maxBuckets, Integer.MIN_VALUE);
        
        // Place elements in appropriate buckets
        for (int num : nums) {
            int idx = (num - min_val) / bucketSize;
            minBuckets[idx] = Math.min(minBuckets[idx], num);
            maxBuckets[idx] = Math.max(maxBuckets[idx], num);
        }
        
        // Calculate the maximum gap
        int maxGap = 0;
        int prevMax = min_val;
        
        for (int i = 0; i < bucketCount; i++) {
            if (minBuckets[i] == Integer.MAX_VALUE) continue;
            maxGap = Math.max(maxGap, minBuckets[i] - prevMax);
            prevMax = maxBuckets[i];
        }
        
        return maxGap;
    }
}
