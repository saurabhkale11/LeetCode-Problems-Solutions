class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0; // Base case: if root is null, the depth is 0
        }

        // If the left subtree is null, recursively find the depth of the right subtree
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        // If the right subtree is null, recursively find the depth of the left subtree
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        // If both left and right subtrees are not null, return the minimum depth of the two subtrees
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        return Math.min(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(solution.minDepth(root1)); // Output: 2

        // Test case 2
        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(4);
        root2.right.right.right = new TreeNode(5);
        root2.right.right.right.right = new TreeNode(6);
        System.out.println(solution.minDepth(root2)); // Output: 5
    }
}
