import java.util.*;

public class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> freq = new HashMap<>();
        freq.put(0, 1L);  // Initial state: prefix mod count is 0

        long res = 0;
        int curr = 0;

        for (int num : nums) {
            if (num % modulo == k) {
                curr = (curr + 1) % modulo;
            }

            int target = (curr - k + modulo) % modulo;
            res += freq.getOrDefault(target, 0L);

            freq.put(curr, freq.getOrDefault(curr, 0L) + 1);
        }

        return res;
    }
}
