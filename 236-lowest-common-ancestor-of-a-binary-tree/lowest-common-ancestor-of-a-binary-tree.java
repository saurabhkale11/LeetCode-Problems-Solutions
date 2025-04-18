class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the root is null or matches one of the nodes, return root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively find LCA in the left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        
        // Recursively find LCA in the right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If both left and right are non-null, the current root is the LCA
        if (left != null && right != null) {
            return root;
        }
        
        // If only one of the subtrees is non-null, return that subtree's LCA
        return left != null ? left : right;
    }
}
