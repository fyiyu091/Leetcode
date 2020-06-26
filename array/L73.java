package array;

/* Set matrix zeros
   If an element is 0, set its entire row and column to 0
   mark the corresponding row and col 0 to the first row and first col,
   however before do that need to check whether the first row or col
   has 0 originally
 */
public class L73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        boolean firstColHasZero = false;
        boolean firstRowHasZero = false;

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
            }
        }

        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstColHasZero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }

        if (firstRowHasZero) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
