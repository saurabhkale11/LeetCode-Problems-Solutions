import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        // Start from the second last row, and update each element
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                // Update the current element with the minimum sum of adjacent elements in the row below
                int minAdjacent = Math.min(triangle.get(row + 1).get(col), triangle.get(row + 1).get(col + 1));
                triangle.get(row).set(col, triangle.get(row).get(col) + minAdjacent);
            }
        }
        
        // The top element now contains the minimum path sum
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        List<List<Integer>> triangle1 = List.of(
            List.of(2),
            List.of(3, 4),
            List.of(6, 5, 7),
            List.of(4, 1, 8, 3)
        );
        int result1 = solution.minimumTotal(triangle1);
        System.out.println(result1);  // Output: 11

        // Example 2
        List<List<Integer>> triangle2 = List.of(
            List.of(-10)
        );
        int result2 = solution.minimumTotal(triangle2);
        System.out.println(result2);  // Output: -10
    }
}
