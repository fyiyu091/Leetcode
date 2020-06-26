package binaryreduction;

/*
   each column are sorted in ascending from top to bottom but not
   necessarily later than the last element of previous row
   Using the sort space algorithm, starting from left bottom corner
   the time complexity can become O(m + n)
*/

public class L240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int x = row - 1;
        int y = 0;

        while (x >= 0 && y < col) {
            if (matrix[x][y] == target) {
                return true;
            }
            else if (matrix[x][y] > target) {
                x--;
            }
            else {
                y++;
            }
        }
        return false;
    }
}
