package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
   Word search II
 */
public class L212 {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String str : words) {
            searchWord(res, board, str);
        }
        return res;
    }

    private void searchWord(List<String> res, char[][] board, String str) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, str, i, j, 0, new HashSet<>())) {
                    res.add(str);
                    return;
                }
            }
        }
    }

    private boolean dfs(char[][] board, String str, int i, int j, int idx, Set<Integer> set) {
        if (idx == str.length()) {
            return true;
        }

        int row = board.length;
        int col = board[0].length;
        if (i < 0 || i > row - 1 || j < 0 || j > col - 1 || board[i][j] != str.charAt(idx) || set.contains(i * col + j)) {
            return false;
        }

        set.add(i * col + j);
        for (int[] dir : DIRECTIONS) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if (dfs(board, str, ii, jj, idx + 1, set)) {
                return true;
            }
        }
        set.remove(i * col + j);

        return false;
    }
}
