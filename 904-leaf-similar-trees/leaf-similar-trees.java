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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return getLeafSequence(root1).equals(getLeafSequence(root2));
    }
    
    private List<Integer> getLeafSequence(TreeNode root) {
        List<Integer> leafSequence = new ArrayList<>();
        traverseTree(root, leafSequence);
        return leafSequence;
    }
    
    private void traverseTree(TreeNode root, List<Integer> leafSequence) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leafSequence.add(root.val);
        }
        traverseTree(root.left, leafSequence);
        traverseTree(root.right, leafSequence);
    }
}
