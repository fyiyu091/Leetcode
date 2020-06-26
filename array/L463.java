package array;

public class L463 {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;

        int res = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int tmp = 4;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        tmp--;
                    }
                    if (i + 1 < row && grid[i + 1][j] == 1) {
                        tmp--;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        tmp--;
                    }
                    if (j + 1 < col && grid[i][j + 1] == 1) {
                        tmp--;
                    }
                    res += tmp;
                }
            }
        }

        return res;
    }
}
