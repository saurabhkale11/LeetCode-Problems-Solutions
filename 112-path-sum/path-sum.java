class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;  // Base case: empty tree
        }

        // If we reach a leaf node
        if (root.left == null && root.right == null) {
            return root.val == targetSum;  // Check if the remaining sum matches the leaf node value
        }

        // Recursively check the left and right subtrees with the updated target sum
        targetSum -= root.val;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right.right.right = new TreeNode(1);

        System.out.println(solution.hasPathSum(root1, 22));  // Output: true

        // Test case 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println(solution.hasPathSum(root2, 5));  // Output: false

        // Test case 3
        TreeNode root3 = null;
        System.out.println(solution.hasPathSum(root3, 0));  // Output: false
    }
}
