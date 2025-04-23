import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPaths(root, targetSum, currentPath, result);
        return result;
    }

    private void findPaths(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;  // Base case: if the node is null, return
        }

        // Add the current node's value to the path
        currentPath.add(node.val);

        // If it's a leaf node, check if the path sum equals the targetSum
        if (node.left == null && node.right == null && targetSum == node.val) {
            result.add(new ArrayList<>(currentPath));  // Add the current path to the result
        } else {
            // Continue to explore left and right children with updated target sum
            findPaths(node.left, targetSum - node.val, currentPath, result);
            findPaths(node.right, targetSum - node.val, currentPath, result);
        }

        // Backtrack: remove the current node from the path before returning
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right.right.left = new TreeNode(5);
        root1.right.right.right = new TreeNode(1);
        
        List<List<Integer>> result1 = solution.pathSum(root1, 22);
        System.out.println(result1);  // Output: [[5, 4, 11, 2], [5, 8, 4, 5]]

        // Test case 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        
        List<List<Integer>> result2 = solution.pathSum(root2, 5);
        System.out.println(result2);  // Output: []

        // Test case 3
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        
        List<List<Integer>> result3 = solution.pathSum(root3, 0);
        System.out.println(result3);  // Output: []
    }
}
