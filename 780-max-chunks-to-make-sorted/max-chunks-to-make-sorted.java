public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int maxSoFar = -1;  // To track the maximum value encountered up to the current index
        int chunks = 0;  // To count the number of chunks
        
        // Iterate through the array
        for (int i = 0; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, arr[i]);  // Update the maximum value encountered
            if (maxSoFar == i) {  // If the max value so far is equal to the current index
                chunks++;  // We can split here
            }
        }
        
        return chunks;  // Return the number of chunks
    }
}
