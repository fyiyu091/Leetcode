package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class L200 {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && set.add(i * col + j)) {
                    res++;
                    bfs(grid, i, j, set);
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int i, int j, Set<Integer> set) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i * col + j);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int x = curr / col;
            int y = curr % col;
            for (int[] dir : DIRECTIONS) {
                int xx = x + dir[0];
                int yy = y + dir[1];
                if (xx >= 0 && xx < row && yy >= 0 && yy < col && grid[xx][yy] == '1' && set.add(xx * col + yy)) {
                    queue.offer(xx * col + yy);
                }
            }
        }
    }
}
