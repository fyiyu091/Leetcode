package dp;

/* Interleaving string */

public class L97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        // corner case
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }

        // row is for s1, col is for s2
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        for (int i = 1; i < len1 + 1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
            }
            else {
                break;
            }
        }
        for (int j = 1; j < len2 + 1; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                dp[0][j] = true;
            }
            else {
                break;
            }
        }

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                char ch1 = s1.charAt(i - 1);
                char ch2 = s2.charAt(j - 1);
                char ch3 = s3.charAt(i + j - 1);
                if (ch3 == ch1) {
                    dp[i][j] |= dp[i - 1][j];
                }
                if (ch3 == ch2) {
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }

        return dp[len1][len2];
    }
}
