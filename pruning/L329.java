package pruning;

/* Given an integer matrix, find the length of the longest increasing path
*  Time complexity is O(m*n), because if one iteration touches all the element,
*  It will stores the value for each element, so any subsequent touch will be O(1)
* */

public class L329 {
    private int max = 0;
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] mem = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, dfs(matrix, i, j, mem));
            }
        }

        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] mem) {
        if (mem[i][j] != 0) {
            return mem[i][j];
        }

        int row = matrix.length;
        int col = matrix[0].length;
        for (int[] dir : DIRECTIONS) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if (ii >= 0 && ii < row && jj >= 0 && jj < col && matrix[ii][jj] > matrix[i][j]) {
                mem[i][j] = Math.max(mem[i][j], dfs(matrix, ii, jj, mem));
            }
        }
        return ++mem[i][j];
    }
}
