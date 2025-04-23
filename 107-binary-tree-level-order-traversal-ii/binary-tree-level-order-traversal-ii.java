import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(0, currentLevel); // Add the current level at the beginning to get bottom-up order
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(solution.levelOrderBottom(root1)); // Output: [[15, 7], [9, 20], [3]]

        // Example 2
        TreeNode root2 = new TreeNode(1);
        System.out.println(solution.levelOrderBottom(root2)); // Output: [[1]]

        // Example 3
        TreeNode root3 = null;
        System.out.println(solution.levelOrderBottom(root3)); // Output: []
    }
}
