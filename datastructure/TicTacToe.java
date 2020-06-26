package datastructure;

public class TicTacToe {
    private int[] rowCounter;
    private int[] colCounter;
    private int diag;
    private int antiDiag;
    private int n;

    public TicTacToe(int n) {
        rowCounter = new int[n];
        colCounter = new int[n];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        rowCounter[row] += (player == 1) ? 1 : -1;
        colCounter[col] += (player == 1) ? 1 : -1;
        if (row == col) {
            antiDiag += (player == 1) ? 1 : -1;
        }
        if (row + col == n - 1) {
            diag += (player == 1) ? 1 : -1;
        }
        if (rowCounter[row] == n || colCounter[col] == n || diag == n || antiDiag == n) {
            return 1;
        }
        if (rowCounter[row] == -n || colCounter[col] == -n || diag == -n || antiDiag == -n) {
            return 2;
        }
        return 0;
    }
}
