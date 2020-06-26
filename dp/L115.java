package dp;

/* Distinct subsequences, count the number of distinct subsequences of S that equals to T */

public class L115 {
    public int numDistinct(String s, String t) {
        if (t == null || t.length() == 0) {
            return 0;
        }

        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        // if t is empty, then s only have one subsequence match no matter how long s is
        // so the first column will be 1
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        // if s is empty, then except empty to empty, the others should be 0
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[sLen][tLen];
    }
}
