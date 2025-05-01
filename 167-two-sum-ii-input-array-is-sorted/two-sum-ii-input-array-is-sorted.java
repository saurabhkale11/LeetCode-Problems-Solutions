public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                return new int[] {left + 1, right + 1}; // 1-indexed result
            }
            else if (sum < target) {
                left++; // Increase the sum by moving the left pointer
            } else {
                right--; // Decrease the sum by moving the right pointer
            }
        }
        
        // Return an empty array if no solution is found (although the problem guarantees a solution)
        return new int[] {};
    }
}
