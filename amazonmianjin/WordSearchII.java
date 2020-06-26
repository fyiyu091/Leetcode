package amazonmianjin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Try not to use the same char */

public class WordSearchII {
    class TrieNode {
        private char ch;
        TrieNode[] children;
        boolean isWord;

        public TrieNode(char ch) {
            this.ch = ch;
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }

        TrieNode root = new TrieNode('\0');
        for (String word : words) {
            build(root, word);
        }

        int row = board.length;
        int col = board[0].length;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(root, board, i, j, visited, res, new StringBuilder());
            }
        }

        return res;
    }

    private void dfs(TrieNode curr, char[][] board, int i, int j, Set<Integer> set, List<String> res, StringBuilder sb) {
        if (curr.isWord) {
            res.add(sb.toString());
            curr.isWord = false;
            return;
        }

        int row = board.length;
        int col = board[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || set.contains(i * col + j) || curr.children[board[i][j] - 'a'] == null) {
            return;
        }

        set.add(i * col + j);
        sb.append(board[i][j]);
        int size = res.size();
        curr = curr.children[board[i][j] - 'a'];
        dfs(curr, board, i + 1, j, set, res, sb);
        dfs(curr, board, i - 1, j, set, res, sb);
        dfs(curr, board, i, j + 1, set, res, sb);
        dfs(curr, board, i, j - 1, set, res, sb);
        // Using size to check if the dfs has found a word
        if (res.size() == size) {
            set.remove(i * col + j);
        }
        sb.setLength(sb.length() - 1);
        return;
    }

    private void build(TrieNode root, String words) {
        TrieNode curr = root;
        for (char ch : words.toCharArray()) {
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode(ch);
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isWord = true;
    }
}
