package trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class L212 {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    class TrieNode {
        private char ch;
        private TrieNode[] neis;
        private boolean isWord;

        TrieNode(char ch) {
            this.ch = ch;
            this.neis = new TrieNode[26];
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return res;
        }

        TrieNode root = new TrieNode('\0');
        buildTrie(root, words);

        int row = board.length;
        int col = board[0].length;
        TrieNode curr = root;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, curr, res, i, j, new StringBuilder(), new HashSet<>());
            }
        }

        return res;
    }

    private void dfs(char[][] board, TrieNode curr, List<String> res, int i, int j, StringBuilder sb, HashSet<Integer> visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited.contains(i * board[0].length + j) || curr.neis[board[i][j] - 'a'] == null) {
            return;
        }

        visited.add(i * board[0].length + j);
        sb.append(board[i][j]);
        curr = curr.neis[board[i][j] - 'a'];
        if (curr.isWord) {
            res.add(sb.toString());
            curr.isWord = false; //if isWord should continue
        }

        for (int[] dir : DIRECTIONS) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            dfs(board, curr, res, ii, jj, sb, visited);
        }

        visited.remove(i * board[0].length + j);
        sb.setLength(sb.length() - 1);
    }

    private void buildTrie(TrieNode root, String[] words) {
        for (String word : words) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                if (curr.neis[ch - 'a'] == null) {
                    curr.neis[ch - 'a'] = new TrieNode(ch);
                }
                curr = curr.neis[ch - 'a'];
            }
            curr.isWord = true;
        }
    }
}
