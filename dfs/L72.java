package dfs;

/* Edit distance, the dfs solution */

public class L72 {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) return -1;
        if (word1 == null) return word2.length();
        if (word2 == null) return word1.length();

        return dfs(word1, word2, 0, 0);
    }

    private int dfs(String word1, String word2, int idx1, int idx2) {
        if (idx1 == word1.length()) {
            return word2.length() - idx2;
        }

        if (idx2 == word2.length()) {
            return word1.length() - idx1;
        }

        if (word1.charAt(idx1) == word2.charAt(idx2)) {
            return dfs(word1, word2, idx1 + 1, idx2 + 1);
        }
        else {
            int insert = dfs(word1, word2, idx1, idx2 + 1);
            int remove = dfs(word1, word2, idx1 + 1, idx2);
            int replace = dfs(word1, word2, idx1 + 1, idx2 + 1);
            return 1 + Math.min(Math.min(insert, remove), replace);
        }
    }
}
