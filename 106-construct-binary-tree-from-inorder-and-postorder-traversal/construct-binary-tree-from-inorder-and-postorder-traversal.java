class Solution {
    private int postIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return helper(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int inLeft, int inRight) {
        if (inLeft > inRight) return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = inorderIndexMap.get(rootVal);

        root.right = helper(inorder, postorder, inIndex + 1, inRight);
        root.left = helper(inorder, postorder, inLeft, inIndex - 1);

        return root;
    }
}
