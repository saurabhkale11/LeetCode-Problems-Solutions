import java.util.*;

public class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> 
            Double.compare(b[0], a[0]));

        for (int[] c : classes) {
            int pass = c[0], total = c[1];
            double gain = ((double)(pass + 1) / (total + 1)) - ((double)pass / total);
            pq.offer(new double[]{gain, pass, total});
        }

        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            int pass = (int) top[1], total = (int) top[2];
            pass++;
            total++;
            double gain = ((double)(pass + 1) / (total + 1)) - ((double)pass / total);
            pq.offer(new double[]{gain, pass, total});
        }

        double totalRatio = 0.0;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            int pass = (int) top[1], total = (int) top[2];
            totalRatio += (double) pass / total;
        }

        return totalRatio / classes.length;
    }
}
