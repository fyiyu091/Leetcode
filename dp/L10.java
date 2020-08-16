package dp;

/* . matches any single character, * matches zero or more of the preceding element
   how to branch, * can match zero or 1 or 2 ... preceding character
   dp[i][j] whether [0, i) and [0, j) can be matched

   a  a  b
   c * a * b
       "" a a b
    "" T  F F F
    c  F  F F F
    *  T  F F F
    a  F  T F F
    *  T  T T F
    b  F  F F T

       "" a a a a a
   ""  T  F F F F F
   b   F  F F F F F
   *   T  F F F F F
   a   F  T F F F F
   *   T  T T T T T

   dp[i][j]
   1. if charAt(i - 1) == charAt(j - 1) || charAt(i - 1) == .
      dp[i][j] = dp[i - 1][j - 1]
   2. if charAt(i - 1) == *
      dp[i][j] = dp[i - 2][j] || dp[i][j - 1] if (charAt(j - 1) == charAt(i - 2) || chatAt(i - 2) == .
   3. dp[i][j] = false

   aa can match b*a*
   a matches with b*a* -> "" matches with b*a*
   aa matches with b*a* -> a matches with b*a*
 */
public class L10 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[pLen + 1][sLen + 1];
        dp[0][0] = true;
        // Taking care of the a*b* base case
        for (int i = 2; i < dp.length; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 2][0];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (p.charAt(i - 1) == '*') {
                    boolean empty = dp[i - 2][j];
                    if (p.charAt(i - 2) == '.' || p.charAt(i - 2) == s.charAt(j - 1)) {
                        dp[i][j] = dp[i][j - 1];
                    }
                    dp[i][j] |= empty;
                }
                else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[pLen][sLen];
    }
}
