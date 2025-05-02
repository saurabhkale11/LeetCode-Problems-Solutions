import java.util.*;

public class Solution {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0;
        long count = 0;

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.lastKey() - map.firstKey() > 2) {
                int leftVal = nums[left];
                map.put(leftVal, map.get(leftVal) - 1);
                if (map.get(leftVal) == 0) map.remove(leftVal);
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}
