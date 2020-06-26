package dfs;

/* Word pattern II */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L291 {
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }

        return dfs(pattern, 0, str, 0, new HashMap<>(), new HashSet<>());
    }

    private boolean dfs(String pattern, int pIdx, String str, int sIdx, Map<Character, String> map, Set<String> used) {
        if (pIdx == pattern.length() && sIdx == str.length()) {
            return true;
        }
        if (pIdx == pattern.length() || sIdx == str.length()) {
            return false;
        }

        char ch = pattern.charAt(pIdx);
        if (!map.containsKey(ch)) {
            for (int i = sIdx + 1; i <= str.length(); i++) {
                String tmp = str.substring(sIdx, i);
                if (used.contains(tmp)) {
                    continue;
                }
                map.put(ch, tmp);
                used.add(tmp);
                if (dfs(pattern, pIdx + 1, str, i, map, used)) {
                    return true;
                }
                map.remove(ch);
                used.remove(tmp);
            }
        }
        else {
            if (map.get(ch).length() + sIdx > str.length()) {
                return false;
            }
            String tmp = str.substring(sIdx, sIdx + map.get(ch).length());
            if (!tmp.equals(map.get(ch))) {
                return false;
            }
            return dfs(pattern, pIdx + 1, str, sIdx + map.get(ch).length(), map, used);
        }
        return false;
    }
}
