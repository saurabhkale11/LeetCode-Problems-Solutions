public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int leftDepth = getDepth(root, true);
        int rightDepth = getDepth(root, false);
        
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    
    private int getDepth(TreeNode node, boolean left) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = left ? node.left : node.right;
        }
        return depth;
    }
}
