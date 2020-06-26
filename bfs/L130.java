package bfs;

import java.util.LinkedList;
import java.util.Queue;

/* Capture Surrounded regions like Go */
public class L130 {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }

        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    if (board[i][j] == 'O') {
                        bfs(board, i, j, visited);
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }

        return;
    }

    private void bfs(char[][] board, int i, int j, boolean[][] visited) {
        int row = board.length;
        int col = board[0].length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i * col + j);
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int x = curr / col;
            int y = curr % col;
            board[x][y] = 'Y';
            for (int[] dir : DIRECTIONS) {
                int xx = x + dir[0];
                int yy = y + dir[1];
                if (xx > 0 && xx < row - 1 && yy > 0 && yy < col - 1 && board[xx][yy] == 'O' && visited[xx][yy] == false) {
                    // Mark 'Y' at this point then we don't need visited 
                    queue.offer(xx * col + yy);
                    visited[xx][yy] = true;
                }
            }
        }
        return;
    }
}
