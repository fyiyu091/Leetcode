package pruning;

import java.util.*;

/* Word break II, return List<String> contains all the broken words */

public class L140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        for (String str : wordDict) {
            dict.add(str);
        }
        boolean[] mem = new boolean[s.length() + 1];
        Arrays.fill(mem, true);
        dfs(res, s, new StringBuilder(), 0, dict, mem);
        return res;
    }

    private void dfs(List<String> res, String s, StringBuilder sb, int index, Set<String> dict, boolean[] mem) {
        if (index == s.length()) {
            sb.setLength(sb.length() - 1);
            res.add(sb.toString());
            return;
        }

        if (!mem[index]) {
            return;
        }

        int originLen = sb.length();
        int resSize = res.size();
        for (int i = index + 1; i <= s.length(); i++) {
            String str = s.substring(index, i);
            if (dict.contains(str)) {
                sb.append(str + " ");
                dfs(res, s, sb, i, dict, mem);
                sb.setLength(originLen);
            }
        }
        if (res.size() == resSize) {
            mem[index] = false;
        }
        return;
    }
}
