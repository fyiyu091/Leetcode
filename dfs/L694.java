package dfs;

import java.util.HashSet;
import java.util.Set;

public class L694 {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, sb, i, j, 's');
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, StringBuilder sb, int i, int j, char ch) {
        int row = grid.length;
        int col = grid[0].length;
        if (i >= 0 && i < row && j >= 0 && j < col && grid[i][j] == 1) {
            grid[i][j] = 0;
            sb.append(ch);
            dfs(grid, sb, i + 1, j, 'd');
            dfs(grid, sb, i - 1, j, 'u');
            dfs(grid, sb, i, j + 1, 'r');
            dfs(grid, sb, i, j - 1, 'l');
            sb.append('#');
        }
    }
}
