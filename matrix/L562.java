package matrix;

/*
    Find the longest line of consecutive one in Matrix
    Need to use the diagonal and anti-diagonal formula
    j + i and j - i + mat.length
 */
public class L562 {
    public int longestLine(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int res = 0;
        int[] colOnes = new int[col];
        int[] diag = new int[row + col];
        int[] antiDiag = new int[row + col];

        for (int i = 0; i < row; i++) {
            int rowOnes = 0;
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    rowOnes++;
                    colOnes[j]++;
                    diag[j - i + row]++;
                    antiDiag[j + i]++;
                    res = Math.max(res, rowOnes);
                    res = Math.max(res, colOnes[j]);
                    res = Math.max(res, diag[j - i + row]);
                    res = Math.max(res, antiDiag[j + i]);
                }
                else {
                    rowOnes = 0;
                    colOnes[j] = 0;
                    diag[j - i + row] = 0;
                    antiDiag[j + i] = 0;
                }
            }
        }

        return res;
    }
}
