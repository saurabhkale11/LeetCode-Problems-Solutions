import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Flatten the grid into a single list of integers
        List<Integer> nums = new ArrayList<>();
        for (int[] row : grid) {
            for (int num : row) {
                nums.add(num);
            }
        }
        
        // Check if all numbers can be made equal
        int first = nums.get(0);
        for (int num : nums) {
            if ((num - first) % x != 0) {
                return -1; // If any number cannot be adjusted to the first number
            }
        }
        
        // Normalize the grid values by subtracting the first element
        for (int i = 0; i < nums.size(); i++) {
            nums.set(i, (nums.get(i) - first) / x);
        }
        
        // Sort the normalized values to find the median
        Collections.sort(nums);
        int median = nums.get(nums.size() / 2);
        
        // Calculate the total number of operations to make all elements equal to the median
        int operations = 0;
        for (int num : nums) {
            operations += Math.abs(num - median);
        }
        
        return operations;
    }
}
