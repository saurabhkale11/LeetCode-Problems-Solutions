import java.util.*;

public class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int level = 0;  // Start at the root (level 0)
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> currentLevelNodes = new ArrayList<>();
            
            // Collect nodes for the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevelNodes.add(node);
                
                // Add children to the queue for the next level
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            // Reverse the nodes' values if the level is odd
            if (level % 2 == 1) {
                int left = 0;
                int right = currentLevelNodes.size() - 1;
                while (left < right) {
                    // Swap values of nodes at odd level
                    TreeNode leftNode = currentLevelNodes.get(left);
                    TreeNode rightNode = currentLevelNodes.get(right);
                    int temp = leftNode.val;
                    leftNode.val = rightNode.val;
                    rightNode.val = temp;
                    
                    left++;
                    right--;
                }
            }
            
            // Move to the next level
            level++;
        }
        
        return root;
    }
}
