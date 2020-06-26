package pruning;

/* Palindrome partitioning, return minimum cuts needed */

public class L132 {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }

        Integer[] mem = new Integer[s.length() + 1];

        return dfs(s, 0, mem);
    }

    private int dfs(String s, int idx, Integer[] mem) {
        if (mem[idx] != null) {
            return mem[idx];
        }

        if (idx == s.length() || isPalindrome(s.substring(idx))) {
            mem[idx] = 0;
            return mem[idx];
        }

        int res = s.length() - 1;
        for (int i = idx; i <= s.length(); i++) {
            if (isPalindrome(s.substring(idx, i))) {
                res = Math.min(res, 1 + dfs(s, i, mem));
            }
        }

        mem[idx] = res;
        return mem[idx];
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
