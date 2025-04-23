import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    private int preorderIndex = 0;
    private HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Store the index of each element in inorder array for efficient look-up
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) {
            return null;
        }

        // The current root is the element in the preorder array
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Build left and right subtrees recursively
        int inorderIndex = inorderMap.get(rootValue);
        root.left = buildTreeHelper(preorder, inorderStart, inorderIndex - 1);
        root.right = buildTreeHelper(preorder, inorderIndex + 1, inorderEnd);

        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode root1 = solution.buildTree(preorder1, inorder1);
        printTree(root1); // Print the tree

        // Test case 2
        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        TreeNode root2 = solution.buildTree(preorder2, inorder2);
        printTree(root2); // Print the tree
    }

    // Helper function to print the tree (for testing purposes)
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
