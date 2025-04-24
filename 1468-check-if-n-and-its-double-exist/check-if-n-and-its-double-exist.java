import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        
        for (int num : arr) {
            if (seen.contains(num * 2) || (num % 2 == 0 && seen.contains(num / 2))) {
                return true;
            }
            seen.add(num);
        }
        
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] arr1 = {10, 2, 5, 3};
        System.out.println(sol.checkIfExist(arr1)); // Expected: true
        
        int[] arr2 = {3, 1, 7, 11};
        System.out.println(sol.checkIfExist(arr2)); // Expected: false
    }
}
