import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        // Step 1: Record the last occurrence of each character
        int[] lastOccurrence = new int[26]; // Since there are 26 lowercase English letters
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }
        
        List<Integer> result = new ArrayList<>();
        int start = 0; // Start index of the current partition
        int end = 0;   // End index of the current partition
        
        // Step 2: Iterate through the string and form partitions
        for (int i = 0; i < s.length(); i++) {
            // Update the farthest last occurrence
            end = Math.max(end, lastOccurrence[s.charAt(i) - 'a']);
            
            // If we reach the end of a partition
            if (i == end) {
                result.add(i - start + 1); // Add the size of the partition
                start = i + 1; // Start a new partition
            }
        }
        
        return result;
    }
}
