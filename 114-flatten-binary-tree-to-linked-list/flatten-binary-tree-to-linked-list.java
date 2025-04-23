class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;  // Base case: if the tree is empty, return
        }
        
        // Flatten the left and right subtree first
        flatten(root.left);
        flatten(root.right);

        // If there is a left subtree, we need to connect it to the right
        if (root.left != null) {
            // Save the right child of the current node
            TreeNode temp = root.right;
            
            // Move the left subtree to the right
            root.right = root.left;
            root.left = null;
            
            // Find the rightmost node of the new right subtree (which was the left subtree)
            TreeNode current = root.right;
            while (current.right != null) {
                current = current.right;
            }
            
            // Connect the saved right subtree to the right of the rightmost node
            current.right = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(6);
        
        solution.flatten(root1);
        printTree(root1);  // Output: [1,null,2,null,3,null,4,null,5,null,6]

        // Test case 2: Empty tree
        TreeNode root2 = null;
        solution.flatten(root2);
        printTree(root2);  // Output: []

        // Test case 3: Tree with only one node
        TreeNode root3 = new TreeNode(0);
        solution.flatten(root3);
        printTree(root3);  // Output: [0]
    }

    // Helper function to print the flattened tree
    public static void printTree(TreeNode root) {
        while (root != null) {
            System.out.print(root.val);
            if (root.right != null) {
                System.out.print(" -> ");
            }
            root = root.right;
        }
        System.out.println();
    }
}
