package slidingwindow;

/* substring t contains at most distinct characters */

public class L159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int start = 0;
        char char1 = '\0', char2 = '\0';
        int lastIdx1 = -1, lastIdx2 = -1;
        int end = 0;
        int max = 0;

        while (end < s.length()) {
            char ch = s.charAt(end);
            if (ch == char1) {
                lastIdx1 = end;
            }
            else if (ch == char2) {
                lastIdx2 = end;
            }
            else {
                if (lastIdx1 < lastIdx2) {
                    char1 = ch;
                    start = lastIdx1 + 1;
                    lastIdx1 = end;
                }
                else {
                    char2 = ch;
                    start = lastIdx2 + 1;
                    lastIdx2 = end;
                }
            }
            max = Math.max(max, end - start + 1);
            end++;
        }

        return max;
    }
}
