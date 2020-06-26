package dfs;

/* Word break */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String str : wordDict) {
            dict.add(str);
        }

        return dfs(s, dict, 0);
    }

    // dfs means from idx to end of string inclusively both side can be break
    private boolean dfs(String s, Set<String> dict, int idx) {
        if (idx == s.length()) {
            return true;
        }

        for (int i = idx; i <= s.length(); i++) {
            if (dict.contains(s.substring(idx, i)) && dfs(s, dict, i)) {
                return true;
            }
        }

        return false;
    }
}
