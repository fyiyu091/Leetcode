package pruning;

/* Flip game II, makes opponent can't flip two consecutive "++" into "--" */

import java.util.HashMap;
import java.util.Map;

public class L294 {
    public boolean canWin(String s) {
        if (s == null || s.length() <= 1) {
            throw new IllegalArgumentException();
        }

        char[] board = s.toCharArray();
        Map<String, Boolean> mem = new HashMap<>();

        return dfs(board, mem);
    }

    private boolean dfs(char[] board, Map<String, Boolean> mem) {
        String str = String.valueOf(board);
        if (mem.get(str) != null) {
            return mem.get(str);
        }

        for (int i = 0; i < board.length - 1; i++) {
            if (board[i] == '+' && board[i + 1] == '+') {
                board[i] = '-';
                board[i + 1] = '-';
                boolean res = dfs(board, mem);
                board[i] = '+';
                board[i + 1] = '+';
                if (!res) {
                    mem.put(str, true);
                    return true;
                }
            }
        }

        mem.put(str, false);
        return false;
    }
}
