package dfs;

import java.util.ArrayList;
import java.util.List;

/* N Queen, using two integer bit operation to check the diagonal case */

public class L51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        char[][] board = new char[n][n];
        // Build up the 2D char array first
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // i + j
        int forward = 0;
        // i - j + n - 1
        int backward = 0;
        // vertical
        int vertical = 0;
        dfs(res, board, 0, n, forward, backward, vertical);
        return res;
    }

    private void dfs(List<List<String>> res, char[][] board, int level, int n, int forward, int backward, int vertical) {
        if (level == n) {
            // convert the 2D char array to List<String>
            List<String> path = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                path.add(String.valueOf(board[i]));
            }
            res.add(path);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(level, i, forward, backward, vertical, n)) {
                board[level][i] = 'Q';
                forward |= (1 << level + i);
                backward |= (1 << level - i + n - 1);
                vertical |= (1 << i);
                dfs(res, board, level + 1, n, forward, backward, vertical);
                board[level][i] = '.';
                forward ^= (1 << level + i);
                backward ^= (1 << level - i + n - 1);
                vertical ^= (1 << i);
            }
        }
    }

    private boolean isValid(int level, int col, int forward, int backward, int vertical, int n) {
        int checkForward = level + col;
        int checkBackward = level - col + n - 1;
        if ((forward >> checkForward & 1) == 1 || (backward >> checkBackward & 1) == 1 || (vertical >> col & 1) == 1) {
            return false;
        }
        return true;
    }
}
