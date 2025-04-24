import java.util.HashSet;

public class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : arr) {
            // Check if double or half exists in the set
            if (seen.contains(num * 2) || (num % 2 == 0 && seen.contains(num / 2))) {
                return true;
            }
            seen.add(num);
        }
        
        return false;
    }
}
