package bfs;

import java.util.LinkedList;
import java.util.Queue;

/* Build a house on empty land (0), it can reaches all buildings (1) in shortest amount of distance
   there are some obstacle (2) that cannot pass through
*/
public class L317 {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return -1;
        int row = grid.length;
        int col = grid[0].length;
        int[][] cost = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, cost, i, j);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 0 && cost[i][j] != 0) {
                    res = Math.min(cost[i][j], res);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void bfs(int[][] grid, int[][] cost, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(i * col + j);
        visited[i][j] = true;

        int minLen = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                int x = curr / col;
                int y = curr % col;
                for (int[] dir : DIRECTIONS) {
                    int xx = x + dir[0];
                    int yy = y + dir[1];
                    if (xx >= 0 && xx < row && yy >= 0 && yy < col && !visited[xx][yy] && grid[xx][yy] == 0) {
                        visited[xx][yy] = true;
                        queue.offer(xx * col + row);
                        cost[xx][yy] += minLen;
                    }
                }
            }
            minLen++;
        }

        // If the 0 can't be accessible from the 1, then mark it as 2
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < col; y++) {
                if (grid[x][y] == 0) {
                    grid[x][y] = 2;
                }
            }
        }

        return;
    }
}
