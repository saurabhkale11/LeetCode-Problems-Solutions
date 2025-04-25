import java.util.*;

public class Solution {
    public int minimumTime(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // Initial check: You must be able to move at time t = 1
        if (m > 1 && n > 1 && grid[0][1] > 1 && grid[1][0] > 1) return -1;

        int[][] time = new int[m][n];
        for (int[] row : time) Arrays.fill(row, Integer.MAX_VALUE);
        time[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});  // time, row, col

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int t = curr[0], r = curr[1], c = curr[2];

            if (r == m - 1 && c == n - 1) return t;

            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                    int nextTime = t + 1;
                    if (nextTime < grid[nr][nc]) {
                        int wait = grid[nr][nc] - nextTime;
                        if (wait % 2 == 1) wait++;
                        nextTime += wait;
                    }
                    if (nextTime < time[nr][nc]) {
                        time[nr][nc] = nextTime;
                        pq.offer(new int[]{nextTime, nr, nc});
                    }
                }
            }
        }

        return -1;
    }
}
