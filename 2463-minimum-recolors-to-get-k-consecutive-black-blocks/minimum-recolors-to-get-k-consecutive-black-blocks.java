public class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minOps = Integer.MAX_VALUE;
        int currentW = 0;

        for (int i = 0; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') currentW++;

            if (i >= k) {
                if (blocks.charAt(i - k) == 'W') currentW--;
            }

            if (i >= k - 1) {
                minOps = Math.min(minOps, currentW);
            }
        }

        return minOps;
    }
}
