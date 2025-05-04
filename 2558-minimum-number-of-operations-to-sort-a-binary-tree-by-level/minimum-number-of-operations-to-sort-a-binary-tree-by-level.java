import java.util.*;

class Solution {
    public int minimumOperations(TreeNode root) {
        int totalSwaps = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] level = new int[size];

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level[i] = node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            totalSwaps += minSwapsToSort(level);
        }

        return totalSwaps;
    }

    private int minSwapsToSort(int[] arr) {
        int n = arr.length;
        int swaps = 0;
        int[][] valWithIndex = new int[n][2];

        for (int i = 0; i < n; i++) {
            valWithIndex[i][0] = arr[i];
            valWithIndex[i][1] = i;
        }

        Arrays.sort(valWithIndex, Comparator.comparingInt(a -> a[0]));
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] || valWithIndex[i][1] == i) continue;

            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = valWithIndex[j][1];
                cycleSize++;
            }

            if (cycleSize > 1) swaps += (cycleSize - 1);
        }

        return swaps;
    }
}
