import java.util.PriorityQueue;

public class Solution {
    public long pickGifts(int[] gifts, int k) {
        // Max-heap to always get the pile with the most gifts (negative values for max-heap)
        PriorityQueue<Long> heap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        
        // Add all the piles into the max-heap
        for (int gift : gifts) {
            heap.offer((long) gift);  // Cast to long
        }
        
        // Perform the operation k times
        for (int i = 0; i < k; i++) {
            // Extract the pile with the maximum number of gifts
            long maxGifts = heap.poll();
            // Calculate the new number of gifts after the operation
            long newGifts = (long) Math.floor(Math.sqrt(maxGifts));
            // Insert the new value back into the heap
            heap.offer(newGifts);
        }
        
        // Sum up the gifts in the heap
        long totalGifts = 0;
        while (!heap.isEmpty()) {
            totalGifts += heap.poll();
        }
        
        return totalGifts;
    }
}
