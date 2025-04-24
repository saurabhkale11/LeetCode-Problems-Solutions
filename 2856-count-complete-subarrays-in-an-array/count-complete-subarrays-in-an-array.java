import java.util.*;

public class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> distinctSet = new HashSet<>();
        for (int num : nums) {
            distinctSet.add(num);
        }
        int totalDistinct = distinctSet.size();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                seen.add(nums[j]);
                if (seen.size() == totalDistinct) {
                    count++;
                }
            }
        }
        return count;
    }
}
