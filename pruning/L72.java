package pruning;

/* Edit distance, the dfs solution */

public class L72 {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) return -1;
        if (word1 == null) return word2.length();
        if (word2 == null) return word1.length();

        Integer[][] mem = new Integer[word1.length() + 1][word2.length() + 1];

        return dfs(word1, word2, 0, 0, mem);
    }

    private int dfs(String word1, String word2, int idx1, int idx2, Integer[][] mem) {
        if (mem[idx1][idx2] != null) {
            return mem[idx1][idx2];
        }

        if (idx1 == word1.length()) {
            mem[idx1][idx2] = word2.length() - idx2;
            return mem[idx1][idx2];
        }

        if (idx2 == word2.length()) {
            mem[idx1][idx2] = word1.length() - idx1;
            return mem[idx1][idx2];
        }

        if (word1.charAt(idx1) == word2.charAt(idx2)) {
            mem[idx1][idx2] = dfs(word1, word2, idx1 + 1, idx2 + 1, mem);
            return mem[idx1][idx2];
        }
        else {
            int insert = dfs(word1, word2, idx1, idx2 + 1, mem);
            int remove = dfs(word1, word2, idx1 + 1, idx2, mem);
            int replace = dfs(word1, word2, idx1 + 1, idx2 + 1, mem);
            mem[idx1][idx2] = 1 + Math.min(Math.min(insert, remove), replace);
            return mem[idx1][idx2];
        }
    }
}
