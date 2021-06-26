package slidingwindow;

/* Longest substring without repeating characters */

public class L3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int end = 0;
        int start = 0;
        int res = 0;
        int[] cnt = new int[256];

        while (end < s.length()) {
            int ch = s.charAt(end);
            cnt[ch]++;

            // Delete all the way until the ch count is not larger than 1
            while (cnt[ch] > 1) {
                --cnt[s.charAt(start++)];
            }

            res = Math.max(res, end - start + 1);
            end++;
        }

        return res;
    }
}
