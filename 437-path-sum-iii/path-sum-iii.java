import java.util.HashMap;

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
    public int pathSum(TreeNode root, int targetSum) {
        // This will store the count of paths
        HashMap<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); // To handle the case when the path sum equals the target directly
        return dfs(root, targetSum, 0, prefixSumCount);
    }

    private int dfs(TreeNode node, int targetSum, long currentSum, HashMap<Long, Integer> prefixSumCount) {
        if (node == null) return 0;

        // Update the current sum
        currentSum += node.val;

        // Count the number of paths that end at this node and sum to target
        int result = prefixSumCount.getOrDefault(currentSum - targetSum, 0);

        // Update the prefix sum count
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        // Recur on left and right child nodes
        result += dfs(node.left, targetSum, currentSum, prefixSumCount);
        result += dfs(node.right, targetSum, currentSum, prefixSumCount);

        // Backtrack: decrement the current sum count when we're done with the current node
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

        return result;
    }
}
