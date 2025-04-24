from collections import deque

class Solution:
    def minimumObstacles(self, grid):
        m, n = len(grid), len(grid[0])
        directions = [(-1,0), (1,0), (0,-1), (0,1)]
        dist = [[float('inf')] * n for _ in range(m)]
        dist[0][0] = 0
        dq = deque()
        dq.append((0, 0))

        while dq:
            x, y = dq.popleft()
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if 0 <= nx < m and 0 <= ny < n:
                    cost = grid[nx][ny]
                    if dist[nx][ny] > dist[x][y] + cost:
                        dist[nx][ny] = dist[x][y] + cost
                        if cost == 0:
                            dq.appendleft((nx, ny))
                        else:
                            dq.append((nx, ny))

        return dist[m - 1][n - 1]
