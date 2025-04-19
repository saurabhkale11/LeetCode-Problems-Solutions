import java.util.Arrays;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // Sort the points by their end value
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;  // We need at least one arrow to start with
        int lastEnd = points[0][1];  // The end of the first balloon's range

        for (int i = 1; i < points.length; i++) {
            // If the current balloon's start is beyond the last arrow's end
            if (points[i][0] > lastEnd) {
                arrows++;  // Need a new arrow
                lastEnd = points[i][1];  // Update lastEnd to the current balloon's end
            }
        }

        return arrows;
    }
}
