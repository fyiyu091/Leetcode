package bitoperation;

/* Game of life
   1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
   2. Any live cell with two or three live neighbors lives on to the next generation.
   3. Any live cell with more than three live neighbors dies, as if by over-population.
   4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
   Need to update 2D matrix in place and simultaneously
 */
public class L289 {
    private static final int[][] DIRECTIONS = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = 0;
                for (int[] dir : DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col && Math.abs(board[ii][jj]) == 1) {
                        count++;
                    }
                }

                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        board[i][j] = -1; // From live to dead
                    }
                }
                if (board[i][j] == 0) {
                    if (count == 3) {
                        board[i][j] = 2; // From dead to live
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] <= 0) {
                    board[i][j] = 0;
                }
                else {
                    board[i][j] = 1;
                }
            }
        }
    }
}
