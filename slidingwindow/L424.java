package slidingwindow;

/* Find the length of longest sub-string containing all repeating letters you get after performing k operations
*  end++ until all the letters - most frequency letters in the window is larger than k
* */

public class L424 {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int start = 0;
        int end = 0;
        int[] count = new int[26];
        int maxCount = 0;
        int res = 0;
        while (end < s.length()) {
            char ch = s.charAt(end);
            maxCount = Math.max(maxCount, ++count[ch - 'A']);
            while (end - start + 1 - maxCount > k) {
                --count[s.charAt(start++) - 'A'];
            }
            res = Math.max(res, end - start + 1);
            end++;
        }

        return res;
    }
}
