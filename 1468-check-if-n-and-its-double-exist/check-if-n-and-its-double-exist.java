import java.util.HashSet;

public class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        
        // Iterate through each element in the array
        for (int num : arr) {
            // Check if num * 2 or num / 2 (when num is even) exists in the set
            if (seen.contains(num * 2) || (num % 2 == 0 && seen.contains(num / 2))) {
                return true;
            }
            // Add the current number to the set
            seen.add(num);
        }
        
        // Return false if no valid pair is found
        return false;
    }
}
