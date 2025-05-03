class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1);
        return dfs(root, 0, targetSum, prefixSumCount);
    }

    private int dfs(TreeNode node, long currentSum, int target, Map<Long, Integer> prefixSumCount) {
        if (node == null) return 0;

        currentSum += node.val;
        int count = prefixSumCount.getOrDefault(currentSum - target, 0);

        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        count += dfs(node.left, currentSum, target, prefixSumCount);
        count += dfs(node.right, currentSum, target, prefixSumCount);
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

        return count;
    }
}
