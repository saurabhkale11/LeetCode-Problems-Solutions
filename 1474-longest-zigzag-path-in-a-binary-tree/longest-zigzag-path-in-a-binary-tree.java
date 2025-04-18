class Solution {
    int maxZigZag = 0;
    
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        
        // Start the DFS with two directions: left and right
        dfs(root, 0, true); // True means start by moving left
        dfs(root, 0, false); // False means start by moving right
        
        return maxZigZag;
    }
    
    private void dfs(TreeNode node, int length, boolean isLeft) {
        if (node == null) return;
        
        // Update the result with the maximum ZigZag length
        maxZigZag = Math.max(maxZigZag, length);
        
        // If we are going left, next we must go right
        if (isLeft) {
            dfs(node.left, length + 1, false); // Move left -> right
            dfs(node.right, 1, true); // Start new ZigZag from right -> left
        } else {
            dfs(node.right, length + 1, true); // Move right -> left
            dfs(node.left, 1, false); // Start new ZigZag from left -> right
        }
    }
}
