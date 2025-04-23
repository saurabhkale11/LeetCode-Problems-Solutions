class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);

        int currentPathSum = node.val + left + right;

        maxSum = Math.max(maxSum, currentPathSum);

        return node.val + Math.max(left, right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
