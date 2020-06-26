package pruning;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for (String str : wordDict) {
            dict.add(str);
        }

        Boolean[] mem = new Boolean[s.length()];
        return dfs(s, dict, 0, mem);
    }

    // dfs means from idx to end of string inclusively both side can be break
    private boolean dfs(String s, Set<String> dict, int idx, Boolean[] mem) {
        if (idx == s.length()) {
            return true;
        }

        if (mem[idx] != null) {
            return mem[idx];
        }

        for (int i = idx; i <= s.length(); i++) {
            if (dict.contains(s.substring(idx, i)) && dfs(s, dict, i, mem)) {
                mem[idx] = true;
                return true;
            }
        }

        mem[idx] = false;
        return false;
    }
}
