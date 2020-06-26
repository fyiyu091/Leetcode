package dfs;

/* Minimum unique word abbreviation */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L411 {
    public String minAbbreviation(String target, String[] dictionary) {
        if (target == null || dictionary == null) {
            return "";
        }

        String res = "";
        Set<String> allAbbres = new HashSet<>();
        for (String str : dictionary) {
            allAbbres.addAll(getAllAbbre(str));
        }

        int minLen = Integer.MAX_VALUE;
        List<String> targetAbbres = getAllAbbre(target);
        for (String str : targetAbbres) {
            if (!allAbbres.contains(str) && str.length() < minLen) {
                res = str;
                minLen = str.length();
            }
        }

        return res;
    }

    private List<String> getAllAbbre(String str) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), 0, str, 0);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, int idx, String target, int count) {
        if (idx == target.length()) {
            if (count != 0) {
                sb.append(count);
            }
            res.add(sb.toString());
            return;
        }

        char ch = target.charAt(idx);
        // add character
        int originLen = sb.length();
        if (count != 0) {
            sb.append(count);
        }
        sb.append(ch);
        dfs(res, sb, idx + 1, target, 0);
        sb.setLength(originLen);

        // add number
        dfs(res, sb, idx + 1, target, count + 1);
    }
}
