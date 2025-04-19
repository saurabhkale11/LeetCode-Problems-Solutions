import java.util.*;

public class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        
        int left = 0, right = n - 1;
        long total = 0;

        for (int i = 0; i < candidates && left <= right; i++) {
            leftHeap.offer(costs[left++]);
        }

        for (int i = 0; i < candidates && left <= right; i++) {
            rightHeap.offer(costs[right--]);
        }

        while (k-- > 0) {
            if (leftHeap.isEmpty()) {
                total += rightHeap.poll();
                if (left <= right) rightHeap.offer(costs[right--]);
            } else if (rightHeap.isEmpty()) {
                total += leftHeap.poll();
                if (left <= right) leftHeap.offer(costs[left++]);
            } else if (leftHeap.peek() <= rightHeap.peek()) {
                total += leftHeap.poll();
                if (left <= right) leftHeap.offer(costs[left++]);
            } else {
                total += rightHeap.poll();
                if (left <= right) rightHeap.offer(costs[right--]);
            }
        }

        return total;
    }
}
