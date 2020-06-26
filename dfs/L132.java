package dfs;

/* Find the minimum cuts needed for a palindrome partitioning */

public class L132 {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }

        return dfs(s, 0);
    }

    private int dfs(String s, int idx) {
        if (idx == s.length() || isPalindrome(s.substring(idx))) {
            return 0;
        }

        int res = s.length() - 1;
        for (int i = idx; i <= s.length(); i++) {
            if (isPalindrome(s.substring(idx, i))) {
                res = Math.min(res, 1 + dfs(s, i));
            }
        }

        return res;
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
