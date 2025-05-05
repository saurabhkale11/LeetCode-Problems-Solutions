public class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int leftZeros = 0;  // Count of zeros in the left substring
        int rightOnes = 0;  // Count of ones in the right substring
        
        // First, calculate the number of ones in the entire string (this will be the initial rightOnes count)
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                rightOnes++;
            }
        }

        int maxScore = 0;
        
        // Now, iterate through all possible split points
        for (int i = 0; i < n - 1; i++) {  // We must have both left and right substrings non-empty
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }
            
            // Calculate score for the current split
            int currentScore = leftZeros + rightOnes;
            maxScore = Math.max(maxScore, currentScore);
        }
        
        return maxScore;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example 1
        String s1 = "011101";
        System.out.println(solution.maxScore(s1));  // Output: 5
        
        // Example 2
        String s2 = "00111";
        System.out.println(solution.maxScore(s2));  // Output: 5
        
        // Example 3
        String s3 = "1111";
        System.out.println(solution.maxScore(s3));  // Output: 3
    }
}
