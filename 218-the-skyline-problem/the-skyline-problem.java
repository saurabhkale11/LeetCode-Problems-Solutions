import java.util.*;

public class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> events = new ArrayList<>();
        
        // Step 1: Create events for start and end of each building
        for (int[] building : buildings) {
            events.add(new int[] {building[0], building[2]});  // Start event
            events.add(new int[] {building[1], -building[2]}); // End event
        }
        
        // Step 2: Sort the events by x-coordinate, and in case of ties, process start before end
        events.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        
        // Step 3: Use a max-heap (priority queue) to track the current building heights
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(0);  // Start with ground level (height 0)
        
        // Step 4: Process each event
        int prevMaxHeight = 0; // To track the previous maximum height
        for (int[] event : events) {
            int x = event[0];
            int height = event[1];
            
            if (height > 0) {
                // Start event: add the height to the heap
                maxHeap.add(height);
            } else {
                // End event: remove the building from the heap
                maxHeap.remove(-height);
            }
            
            // Step 5: Track the maximum height at the current x-coordinate
            int currentMaxHeight = maxHeap.peek();
            if (currentMaxHeight != prevMaxHeight) {
                // If the height has changed, add a new key point to the result
                result.add(Arrays.asList(x, currentMaxHeight));
                prevMaxHeight = currentMaxHeight;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] buildings = {
            {2, 9, 10},
            {3, 7, 15},
            {5, 12, 12},
            {15, 20, 10},
            {19, 24, 8}
        };
        List<List<Integer>> skyline = sol.getSkyline(buildings);
        
        // Print the result
        for (List<Integer> point : skyline) {
            System.out.println(point);
        }
    }
}
