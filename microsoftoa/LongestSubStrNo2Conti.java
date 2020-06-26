package microsoftoa;

/* String only contains 'a' or 'b' return the longest without three contiguous
   'a' or 'b'
 */
public class LongestSubStrNo2Conti {
    public String longestSubString(String s) {
        if (s == null || s.length() < 3) {
            return s;
        }

        int curr = 0; //
        int end = 1;
        int start = 0; // Anchor pointer
        int maxLen = 2;
        int count = 1;
        char ch = s.charAt(0);

        while (end < s.length()) {
            if (s.charAt(end) == ch) {
                count++;
                if (count == 2) {
                    if (end - curr + 1 > maxLen) {
                        maxLen = end - curr + 1;
                        start = curr;
                    }
                }
                else {
                    curr = end - 1;
                }
            }
            else {
                ch = s.charAt(end);
                count = 1;
                if (end - curr + 1 > maxLen) {
                    maxLen = end - curr + 1;
                    start = curr;
                }
            }
            end++;
        }
        return s.substring(start, start + maxLen);
    }
}
