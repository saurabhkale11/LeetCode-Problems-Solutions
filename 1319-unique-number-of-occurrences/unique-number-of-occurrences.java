import java.util.*;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Create a map to store the frequency of each element in the array
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Count the frequency of each element in the array
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Create a set to track if any frequency occurs more than once
        Set<Integer> frequencySet = new HashSet<>();
        
        // Check if the frequency of each element is unique
        for (int frequency : frequencyMap.values()) {
            if (!frequencySet.add(frequency)) {
                return false;  // If the frequency is already in the set, return false
            }
        }
        
        return true;  // If all frequencies are unique, return true
    }
}
