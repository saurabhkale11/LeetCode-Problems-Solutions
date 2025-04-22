public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;  // Base case: There is one way to arrange 0 nodes.
        dp[1] = 1;  // Base case: There is one way to arrange 1 node.
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];  // Left subtree and right subtree combinations
            }
        }
        
        return dp[n];  // The answer is the number of unique BSTs with 'n' nodes
    }
}
