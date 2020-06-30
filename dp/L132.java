package dp;

/* Palindrome partitioning, return minimum cuts needed
*/

public class L132 {
    public int minCut(String s) {
        // corner case
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        boolean[][] isPalin = new boolean[len][len];
        int[] dp = new int[len + 1];
        dp[len] = 0;

        // i, j are all str_idx
        for (int i = len - 1; i >= 0; i--) { // i is str_idx
            dp[i] = len - i - 1; // "bb" case, when i = 0, dp[i] = 2 - 0 - 1 = 1
            for (int j = i; j < len; j++) {
                isPalin[i][j] = (i == j || (i + 1 == j || isPalin[i + 1][j - 1]) && s.charAt(i) == s.charAt(j));
                if (j == len - 1 && isPalin[i][j]) { // we need this for "bb" case and when i == 0
                    dp[i] = 0;
                }
                if (isPalin[i][j]) {
                    dp[i] = Math.min(dp[i], 1 + dp[j + 1]);
                }
            }
        }
        return dp[0];
    }
}
