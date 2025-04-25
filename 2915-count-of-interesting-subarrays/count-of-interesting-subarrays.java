import java.util.*;

public class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> prefixCount = new HashMap<>();
        prefixCount.put(0, 1L);
        long count = 0, prefix = 0;

        for (int num : nums) {
            if (num % modulo == k) prefix++;
            int key = (int) ((prefix - k) % modulo + modulo) % modulo;
            count += prefixCount.getOrDefault(key, 0L);
            int current = (int) (prefix % modulo);
            prefixCount.put(current, prefixCount.getOrDefault(current, 0L) + 1);
        }

        return count;
    }
}
