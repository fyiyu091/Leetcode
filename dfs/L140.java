package dfs;

/* Word break II, generate all the break solutions in List<String> */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        for (String str : wordDict) {
            dict.add(str);
        }

        dfs(res, new StringBuilder(), s, 0, dict);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, String s, int idx, Set<String> dict) {
        if (idx == s.length()) {
            sb.setLength(sb.length() - 1);
            res.add(sb.toString());
            return;
        }

        for (int i = idx + 1; i <= s.length(); i++) {
            if (dict.contains(s.substring(idx, i))) {
                int originLen = sb.length();
                sb.append(s.substring(idx, i) + " ");
                dfs(res, sb, s, i, dict);
                sb.setLength(originLen);
            }
        }
    }
}
