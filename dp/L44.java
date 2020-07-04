package dp;

/*
   Wildcard matching
   ? matches any single character
   * matches any sequence of character
   How to branch? * can match 0 1 2 3 ...
   dp[i][j] means from [0, i] string whether can matches from [0, j] pattern
   Because we need empty, so the dp have to have more one len to reach len on both

   Assume sIdx and pIdx, if pIdx char == sIdx char || pIdx == '?' dp[i][j] = dp[i - 1][j - 1]
   if pIdx == '*', another story
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 1]
     "" a d c e b
  "" T  F F F F F
  *  T  T T T T T
  a  F  T F F F F
  *  F  T T T T T
  b  F  F F F F T
 */
public class L44 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            throw new IllegalArgumentException();
        }

        int sLen = s.length();
        int pLen = p.length();

        boolean[][] dp = new boolean[pLen + 1][sLen + 1];
        dp[0][0] = true;
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i < dp.length; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
                else if (s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[pLen][sLen];
    }
}
