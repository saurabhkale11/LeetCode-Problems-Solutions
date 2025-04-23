import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        // Initialize the first element
        row.add(1);
        
        // Compute the values for the row
        for (int i = 1; i <= rowIndex; i++) {
            // Update the elements in the row from right to left
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j - 1) + row.get(j));
            }
            // Add 1 as the last element in the row
            row.add(1);
        }
        
        return row;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int rowIndex1 = 3;
        List<Integer> result1 = solution.getRow(rowIndex1);
        System.out.println(result1);  // Output: [1, 3, 3, 1]
        
        // Example 2
        int rowIndex2 = 0;
        List<Integer> result2 = solution.getRow(rowIndex2);
        System.out.println(result2);  // Output: [1]
        
        // Example 3
        int rowIndex3 = 1;
        List<Integer> result3 = solution.getRow(rowIndex3);
        System.out.println(result3);  // Output: [1, 1]
    }
}
