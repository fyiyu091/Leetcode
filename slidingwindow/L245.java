package slidingwindow;

import java.util.Arrays;

public class L245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) {
            return 0;
        }

        int[] idx = new int[2];
        Arrays.fill(idx, -1);
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (word1.equals(word2) && idx[0] != -1) {
                    res = Math.min(res, i - idx[0]);
                }
                idx[0] = i;
            }
            if (words[i].equals(word2)) { // Why do I need this line? This is for word1 != word2 purpose
                idx[1] = i;
            }
            if (idx[0] != -1 && idx[1] != -1 && !word1.equals(word2)) {
                res = Math.min(res, Math.abs(idx[0] - idx[1]));
            }
        }

        return res;
    }
}
