class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length, k = queries.length;
        int[] answer = new int[k];
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        boolean[][] vis = new boolean[m][n];
        pq.offer(new int[]{grid[0][0],0,0});
        vis[0][0] = true;
        int count = 0, idx = 0;
        int[][] queryWithIndex = new int[k][2];
        for (int i = 0; i < k; i++) {
            queryWithIndex[i][0] = queries[i];
            queryWithIndex[i][1] = i;
        }
        Arrays.sort(queryWithIndex, (a,b) -> a[0] - b[0]);
        for (int i = 0; i < k; i++) {
            int q = queryWithIndex[i][0];
            while (!pq.isEmpty() && pq.peek()[0] < q) {
                int[] cur = pq.poll();
                count++;
                int x = cur[1], y = cur[2];
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny]) {
                        vis[nx][ny] = true;
                        pq.offer(new int[]{grid[nx][ny],nx,ny});
                    }
                }
            }
            answer[queryWithIndex[i][1]] = count;
        }
        return answer;
    }
}
