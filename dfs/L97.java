package dfs;

public class L97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        // corner case
        return dfs(s1, 0, s2, 0, s3, 0);
    }

    private boolean dfs(String s1, int i1, String s2, int i2, String s3, int i3) {
        if (i1 == s1.length() && i2 == s2.length() && i3 == s3.length()) {
            return true;
        }
        if (i1 == s1.length()) {
            return s2.substring(i2).equals(s3.substring(i3));
        }
        if (i2 == s2.length()) {
            return s1.substring(i1).equals(s3.substring(i3));
        }

        boolean res = false;
        char ch1 = s1.charAt(i1);
        char ch2 = s2.charAt(i2);
        char ch3 = s3.charAt(i3);
        if (ch1 == ch3) {
            res |= dfs(s1, i1 + 1, s2, i2, s3, i3 + 1);
        }
        if (ch2 == ch3) {
            res |= dfs(s1, i1, s2, i2 + 1, s3, i3 + 1);
        }
        return res;
    }
}
