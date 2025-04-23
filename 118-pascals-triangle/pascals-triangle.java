import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            
            // First and last elements are always 1
            row.add(1);
            
            // Fill in the middle elements
            for (int j = 1; j < i; j++) {
                row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            
            // Last element is always 1
            if (i > 0) {
                row.add(1);
            }
            
            result.add(row);
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        int numRows1 = 5;
        List<List<Integer>> result1 = solution.generate(numRows1);
        System.out.println(result1);
        
        // Example 2
        int numRows2 = 1;
        List<List<Integer>> result2 = solution.generate(numRows2);
        System.out.println(result2);
    }
}
