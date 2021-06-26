package array;

/* Rotate image 90 degrees clockwise */

public class L48 {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }

        dfs(matrix, 0, matrix.length);
        return;
    }

    private void dfs(int[][] matrix, int i, int len) {
        if (len <= 1) {
            return;
        }

        /*
            Why k can't be <= len - 1?
            Because when k == 0, k and len - 1 is swapped already
            If setting k to len - 1, it would redo the k == 0 case
         */
        for (int k = 0; k < len - 1; k++) {
            int tmp = matrix[i][i + k];
            matrix[i][i + k] = matrix[i + len - 1 - k][i];
            matrix[i + len - 1 - k][i] = matrix[i + len - 1][i + len - 1 - k];
            matrix[i + len - 1][i + len - 1 - k] = matrix[i + k][i + len - 1];
            matrix[i + k][i + len - 1] = tmp;
        }

        dfs(matrix, i + 1, len - 2);
        return;
    }
}
