package dfs;

/* Number of islands
   Don't change input */

import java.util.HashSet;
import java.util.Set;

public class L200 {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && set.add(i * col + j)) {
                    res++;
                    dfs(grid, i, j, set);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j, Set<Integer> set) {
        for (int[] dir : DIRECTIONS) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if (ii >= 0 && ii < grid.length && jj >= 0 && jj < grid[0].length && grid[ii][jj] == '1' && set.add(ii * grid[0].length + jj)) {
                dfs(grid, ii, jj, set);
            }
        }
        return;
    }
}
