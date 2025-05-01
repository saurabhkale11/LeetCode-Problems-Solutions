public class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        
        // First pass: Left to Right
        int leftBalls = 0, leftMoves = 0;
        for (int i = 0; i < n; i++) {
            answer[i] += leftMoves;
            if (boxes.charAt(i) == '1') {
                leftBalls++;
            }
            leftMoves += leftBalls;
        }
        
        // Second pass: Right to Left
        int rightBalls = 0, rightMoves = 0;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += rightMoves;
            if (boxes.charAt(i) == '1') {
                rightBalls++;
            }
            rightMoves += rightBalls;
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test cases
        System.out.println(Arrays.toString(sol.minOperations("110")));  // Output: [1, 1, 3]
        System.out.println(Arrays.toString(sol.minOperations("001011")));  // Output: [11, 8, 5, 4, 3, 4]
    }
}
