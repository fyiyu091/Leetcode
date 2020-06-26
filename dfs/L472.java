package dfs;

/* Find the concatenated words in the given array */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class L472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new LinkedList<>();
        if (words == null || words.length == 0) {
            return res;
        }

        Set<String> dict = new HashSet<>();
        for (String str : words) {
            dict.add(str);
        }

        for (String str : words) {
            dict.remove(str);
            if (canBreak(str, dict)) {
                res.add(str);
            }
            dict.add(str);
        }

        return res;
    }

    private boolean canBreak(String str, Set<String> dict) {
        boolean[] dp = new boolean[str.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= str.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dict.contains(str.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    // break right here to improve the time complexity, just the constant factor
                    break;
                }
            }
        }
        return dp[str.length()];
    }
}
