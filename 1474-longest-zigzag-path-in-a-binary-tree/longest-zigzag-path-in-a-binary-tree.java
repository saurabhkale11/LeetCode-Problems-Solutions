class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int maxLength = 0;

    public int longestZigZag(TreeNode root) {
        // Start the DFS from root with both directions
        dfs(root, 0, true); // Start with left direction
        dfs(root, 0, false); // Start with right direction
        return maxLength;
    }

    private void dfs(TreeNode node, int length, boolean isLeft) {
        if (node == null) return;
        
        // Update the global maximum ZigZag length
        maxLength = Math.max(maxLength, length);
        
        // If moving left, the next move should be right, so recurse to the right child
        if (isLeft) {
            dfs(node.left, length + 1, false);  // Move left and next move should be right
            dfs(node.right, 1, true);           // Start a new path by moving right from this node
        } else {
            dfs(node.right, length + 1, true);  // Move right and next move should be left
            dfs(node.left, 1, false);           // Start a new path by moving left from this node
        }
    }
}
