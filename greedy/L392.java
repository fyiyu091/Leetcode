package greedy;

/* Check if s is subsequence of t */

public class L392 {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        int sLen = s.length();
        int tLen = t.length();
        int i = 0;
        int j = 0;
        while (i < sLen && j < tLen) {
            if (t.charAt(j) == s.charAt(i)) {
                i++;
            }
            j++;
        }

        return i == sLen;
    }
}
