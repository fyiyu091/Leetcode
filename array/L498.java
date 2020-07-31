package array;

/*
    Diagonal traverse
    [
    [ 1, 2, 3 ],
    [ 4, 5, 6 ],
    [ 7, 8, 9 ]
    ]

    Output:  [1,2,4,7,5,3,6,8,9]
    if (i + j) % 2 == 0 we move from left bottom to top right else from top right to left bottom
    1. from left bottom to top right
       if col is at the last, row++
       else if row == 0, col++
       else row--, col++

    2. from top right to left bottom
       if row is at the last, col++
       else if col == 0, row++
       else row++, col--

 */
public class L498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new int[0];
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int total = row * col;
        int[] res = new int[total];
        int idx = 0;
        int i = 0, j = 0;
        for (int k = 0; k < total; k++) {
            // from left bottom to top right
            res[idx++] = matrix[i][j];
            if ((i + j) % 2 == 0) {
                if (j == col - 1) {
                    i++;
                }
                else if (i == 0) {
                    j++;
                }
                else {
                    i--;
                    j++;
                }
            }
            // from top right to left bottom
            else {
                if (i == row - 1) {
                    j++;
                }
                else if (j == 0) {
                    i++;
                }
                else {
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
}
