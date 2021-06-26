package slidingwindow;

/* Minimum window substring */
/* When the window is valid, start++ and update res while valid */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> cnt = new HashMap<>();
        Map<Character, Integer> windowCnt = new HashMap<>();

        for (char ch : t.toCharArray()) {
            cnt.put(ch, cnt.getOrDefault(ch, 0) + 1);
        }

        // Two size array to save the window size, because start and end would keep moving
        int[] indice = new int[2];
        Arrays.fill(indice, -1);
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        while (end < s.length()) {
            char ch = s.charAt(end);
            windowCnt.put(ch, windowCnt.getOrDefault(ch, 0) + 1);
            // While it is valid, keep shrink the window size and keep updating the results
            while (isValidWindow(windowCnt, cnt)) {
                if (end - start + 1 < minLen) {
                    indice[0] = start;
                    indice[1] = end;
                    minLen = end - start + 1;
                }
                int letterCnt = windowCnt.get(s.charAt(start));
                letterCnt--;
                if (letterCnt == 0) {
                    windowCnt.remove(s.charAt(start));
                }
                else {
                    windowCnt.put(s.charAt(start), letterCnt);
                }
                start++;
            }
            end++;
        }

        if (indice[0] == -1) {
            return "";
        }

        return s.substring(indice[0], indice[1] + 1);
    }

    private boolean isValidWindow(Map<Character, Integer> windowCnt, Map<Character, Integer> cnt) {
        for (char ch : cnt.keySet()) {
            Integer count = windowCnt.get(ch);
            if (count == null || count < cnt.get(ch)) {
                return false;
            }
        }
        return true;
    }
}
