package bfs;

import java.lang.reflect.Array;
import java.util.*;

public class L417 {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return res;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            pacific[i][0] = true;
            queue.offer(i * col);
        }

        for (int j = 1; j < col; j++) {
            pacific[0][j] = true;
            queue.offer(j);
        }

        bfs(queue, pacific, atlantic, matrix, res);

        for (int i = 0; i < row; i++) {
            atlantic[i][col - 1] = true;
            queue.offer(i * col + col - 1);
        }

        for (int j = 0; j < col - 1; j++) {
            atlantic[row - 1][j] = true;
            queue.offer((row - 1) * col + j);
        }

        bfs(queue, atlantic, pacific, matrix, res);
        return res;
    }

    private void bfs(Queue<Integer> queue, boolean[][] self, boolean[][] other, int[][] matrix, List<List<Integer>> res) {
        int row = matrix.length;
        int col = matrix[0].length;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int i = curr / col;
            int j = curr % col;
            if (other[i][j]) {
                res.add(Arrays.asList(i, j));
            }
            for (int[] dir : DIRECTIONS) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii >= 0 && ii < row && jj >= 0 && jj < col && matrix[i][j] <= matrix[ii][jj] && self[ii][jj] == false) {
                    self[ii][jj] = true;
                    queue.offer(ii * col + jj);
                }
            }
        }
    }
}
