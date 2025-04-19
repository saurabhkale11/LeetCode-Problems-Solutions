import java.util.Arrays;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sort intervals by their end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int lastEnd = intervals[0][1];

        // Iterate through the intervals starting from the second one
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) { // Overlapping intervals
                count++;
            } else {
                lastEnd = intervals[i][1]; // No overlap, update the last end time
            }
        }

        return count;
    }
}
