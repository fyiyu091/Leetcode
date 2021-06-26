package dfs;

/* Given a 2D board and a word, find if the word exists in the grid
*  One special about this solution is that the dfs returns a boolean to the up level
* */

import java.util.HashSet;
import java.util.Set;

public class L79 {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return false;

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Set<Integer> visited = new HashSet<>();
                // Only need one workable path
                if (dfs(board, word, i, j,0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index, Set<Integer> visited) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) || visited.contains(i * board[0].length + j)) {
            return false;
        }
        visited.add(i * board[0].length + j);
        for (int[] dir : DIRECTIONS) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if (dfs(board, word, ii, jj, index + 1, visited)) {
                return true;
            }
        }
        // Remove from the visited so that the char can be used in a different path
        visited.remove(i * board[0].length + j);
        return false;
    }
}
