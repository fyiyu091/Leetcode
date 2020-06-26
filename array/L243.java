package array;

import java.util.Arrays;

public class L243 {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) {
            return 0;
        }

        int[] arr = new int[2];
        Arrays.fill(arr, -1);
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                arr[0] = i;
            }
            if (words[i].equals(word2)) {
                arr[1] = i;
            }
            if (arr[0] != -1 && arr[1] != -1) {
                res = Math.min(res, Math.abs(arr[0] - arr[1]));
            }
        }

        return res;
    }
}
