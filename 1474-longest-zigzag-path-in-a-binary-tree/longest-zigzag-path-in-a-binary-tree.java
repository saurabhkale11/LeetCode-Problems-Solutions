class Solution {
    private int maxZigZag = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root.left, 1, true);  // true means last move was left
        dfs(root.right, 1, false); // false means last move was right
        return maxZigZag;
    }

    private void dfs(TreeNode node, int length, boolean isLeft) {
        if (node == null) return;
        maxZigZag = Math.max(maxZigZag, length);
        if (isLeft) {
            dfs(node.right, length + 1, false); // switch to right
            dfs(node.left, 1, true);            // restart from left
        } else {
            dfs(node.left, length + 1, true);   // switch to left
            dfs(node.right, 1, false);          // restart from right
        }
    }
}
