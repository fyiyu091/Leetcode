package slidingwindow;

/* Find the length of the longest substring T that contains at most K distinct characters */

public class L340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }

        // Assume the string only contains ASCII characters, use a count array to save each character's count
        int start = 0;
        int end = 0;
        int letterCount = 0;
        int len = s.length();
        int max = 0;
        int[] count = new int[256];

        while (end < len) {
            char ch = s.charAt(end);
            if (count[ch]++ == 0) {
                letterCount++;
            }
            while (letterCount > k) {
                if (--count[s.charAt(start++)] == 0) {
                    letterCount--;
                }
            }
            // now we have the window size
            max = Math.max(max, end - start + 1);
            end++;
        }

        return max;
    }
}
