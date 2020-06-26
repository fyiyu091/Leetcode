package dp;

/* Decode ways, given string contains only digits, determine the total number
   of ways to decode it
 */

public class L91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i < len + 1; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i - 2 >= 0) {
                String str = s.substring(i - 2, i);
                int val = convert(str);
                if (val >= 1 && val <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }

        return dp[len];
    }

    private int convert(String str) {
        if (str.charAt(0) == '0' || str.length() != 2) {
            return 0;
        }
        return Integer.valueOf(str);
    }
}
