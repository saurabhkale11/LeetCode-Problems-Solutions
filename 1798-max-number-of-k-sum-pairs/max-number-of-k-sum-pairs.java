import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int operations = 0;
        
        for (int num : nums) {
            int complement = k - num;
            
            if (countMap.getOrDefault(complement, 0) > 0) {
                operations++;
                countMap.put(complement, countMap.get(complement) - 1);
            } else {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }
        
        return operations;
    }
}
