class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public boolean isBalanced(TreeNode root) {
        // Check if the tree is balanced
        return checkBalance(root) != -1;
    }

    // Helper function that returns the height of the tree if it's balanced, otherwise -1
    private int checkBalance(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively check the left subtree
        int leftHeight = checkBalance(node.left);
        if (leftHeight == -1) {
            return -1; // If left subtree is unbalanced, propagate -1
        }

        // Recursively check the right subtree
        int rightHeight = checkBalance(node.right);
        if (rightHeight == -1) {
            return -1; // If right subtree is unbalanced, propagate -1
        }

        // If the current node's subtrees differ in height by more than 1, it's unbalanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Tree is unbalanced
        }

        // Return the height of the current node's subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(solution.isBalanced(root1)); // Output: true

        // Test case 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);
        System.out.println(solution.isBalanced(root2)); // Output: false

        // Test case 3
        TreeNode root3 = null;
        System.out.println(solution.isBalanced(root3)); // Output: true
    }
}
