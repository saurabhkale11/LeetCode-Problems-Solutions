import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        int[] dirs = {0, 1, 0, -1, 0};  // Directions for up, right, down, left
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';  // Mark entrance as visited
        
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];
                
                // Check if it's an exit
                if ((x == 0 || x == m - 1 || y == 0 || y == n - 1) && !(x == entrance[0] && y == entrance[1])) {
                    return steps;
                }
                
                // Explore the four directions
                for (int j = 0; j < 4; j++) {
                    int nx = x + dirs[j], ny = y + dirs[j + 1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && maze[nx][ny] == '.') {
                        maze[nx][ny] = '+';  // Mark as visited
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            
            steps++;
        }
        
        return -1;  // No exit found
    }
}
