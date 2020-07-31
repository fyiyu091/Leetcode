package string;

/* Longest palindromic substring
*
*  maxLen = 3
*
*  0 1 2 3 4 5 6 7
*  i = 4, start should = 3, end should = 5
*  3 = 4 - (3 - 1) / 2
*  5 = 4 + 3 / 2
*
*  same case but maxLen = 4
*  i = 4, start should = 3, end should = 6
*  3 = 4 - (4 - 1) / 2
*  6 = 4 + 4 / 2
* */

public class L5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return null;

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int maxOdd = expand(s, i, i);
            int maxEven = expand(s, i, i + 1);
            int maxLen = Math.max(maxEven, maxOdd);
            if (maxLen > end - start + 1) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
