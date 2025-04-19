import java.util.*;

public class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Map<String, Integer> rowMap = new HashMap<>();
        
        // Iterate through each row
        for (int i = 0; i < m; i++) {
            StringBuilder row1 = new StringBuilder();
            StringBuilder row2 = new StringBuilder();
            
            // Create two possible versions of the row: original and flipped
            for (int j = 0; j < n; j++) {
                row1.append(matrix[i][j]);
                row2.append(1 - matrix[i][j]); // Flipped version
            }
            
            // Choose the lexicographically smaller version
            String rowStr = row1.toString().compareTo(row2.toString()) <= 0 ? row1.toString() : row2.toString();
            
            // Update the count of this row version in the map
            rowMap.put(rowStr, rowMap.getOrDefault(rowStr, 0) + 1);
        }
        
        // Return the maximum count from the map
        int maxRows = 0;
        for (int count : rowMap.values()) {
            maxRows = Math.max(maxRows, count);
        }
        
        return maxRows;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[][] matrix1 = {{0, 1}, {1, 1}};
        System.out.println(solution.maxEqualRowsAfterFlips(matrix1));  // Output: 1
        
        int[][] matrix2 = {{0, 1}, {1, 0}};
        System.out.println(solution.maxEqualRowsAfterFlips(matrix2));  // Output: 2
        
        int[][] matrix3 = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        System.out.println(solution.maxEqualRowsAfterFlips(matrix3));  // Output: 2
    }
}
