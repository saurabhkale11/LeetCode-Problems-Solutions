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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
    
    private int dfs(TreeNode node, int maxVal) {
        if (node == null) return 0;
        
        int count = 0;
        if (node.val >= maxVal) {
            count = 1;  // This node is good
        }
        
        maxVal = Math.max(maxVal, node.val);
        
        count += dfs(node.left, maxVal);
        count += dfs(node.right, maxVal);
        
        return count;
    }
}
