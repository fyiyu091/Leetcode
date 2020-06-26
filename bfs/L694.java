package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/* Number of distinct islands */

public class L694 {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private static final String[] MARK = {"R", "L", "U", "D"};
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        Set<String> res = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && visited.add(i * col + j)) {
                    bfs(grid, i, j, res, visited);
                }
            }
        }
        return res.size();
    }

    private void bfs(int[][] grid, int i, int j, Set<String> res, Set<Integer> visited) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        Queue<Integer> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        queue.offer(i * col + j);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int y = curr / col;
            int z = curr % col;
            for (int x = 0; x < DIRECTIONS.length; x++) {
                int ii = y + DIRECTIONS[x][0];
                int jj = z + DIRECTIONS[x][1];
                if (ii >= 0 && ii < row && jj >= 0 && jj < col && visited.add(ii * col + jj) && grid[ii][jj] == 1) {
                    queue.offer(ii * col + jj);
                    sb.append(MARK[x]);
                }
            }
            sb.append('#');
        }
        res.add(sb.toString());
    }
}
