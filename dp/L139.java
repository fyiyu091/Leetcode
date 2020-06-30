package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Word break, "leetcode" with dict = ["leet", "code"] can be break */

public class L139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        Set<String> dict = new HashSet<>();
        for (String str : wordDict) {
            dict.add(str);
        }

        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) { // i is the index in dp
            for (int j = 0; j < i; j++) { // j is the index in word
                if (dict.contains(s.substring(j, i)) && dp[j]) { // [j, i), because dp[j] meaning word[j - 1]
                    dp[i] = true;
                }
            }
        }

        return dp[len];
    }
}
