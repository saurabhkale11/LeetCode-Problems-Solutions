import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        // Initialize the stack with the leftmost nodes of the tree
        pushLeft(root);
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    public int next() {
        // Pop the top element which is the next smallest element in the in-order traversal
        TreeNode node = stack.pop();
        // If the node has a right child, push all its left children to the stack
        if (node.right != null) {
            pushLeft(node.right);
        }
        return node.val;
    }
    
    private void pushLeft(TreeNode node) {
        // Push all left children of the current node onto the stack
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
