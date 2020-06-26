package dp;

/* Palindrome partitioning, return minimum cuts needed */

public class L132 {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }

        // Here, dp could just be size of s.length() as well
        int[] dp = new int[s.length() + 1];
        // [idx, s.length() - 1] minimum cut
        dp[s.length()] = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (isPalindrome(s.substring(i))) {
                dp[i] = 0;
            }
            else {
                dp[i] = s.length() - i - 1;
                for (int j = i + 1; j <= s.length(); j++) {
                    if (isPalindrome(s.substring(i, j))) {
                        dp[i] = Math.min(dp[i], 1 + dp[j]);
                    }
                }
            }
        }
        return dp[0];
    }

    private boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (str.length() == 1) {
            return true;
        }

        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

}
