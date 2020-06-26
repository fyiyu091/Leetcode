package dp;

/* Edit distance, the dp meaning here is [i, len1) and [j, len2) */

public class L72 {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) return -1;
        if (word1 == null) return word2.length();
        if (word2 == null) return word1.length();

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        dp[word1.length()][word2.length()] = 0;

        for (int i = word1.length() - 1; i >= 0; i--) {
            dp[i][word2.length()] = word1.length() - i;
        }
        for (int j = word2.length() - 1; j >= 0; j--) {
            dp[word1.length()][j] = word2.length() - j;
        }

        for (int i = word1.length() - 1; i >= 0; i--) {
            for (int j = word2.length() - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                }
                else {
                    int insert = dp[i][j + 1];
                    int remove = dp[i + 1][j];
                    int replace = dp[i + 1][j + 1];
                    dp[i][j] = 1 + Math.min(Math.min(insert, remove), replace);
                }
            }
        }

        return dp[0][0];
    }
}
