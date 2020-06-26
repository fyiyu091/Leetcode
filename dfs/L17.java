package dfs;

/* Letter combinations of phone number */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        // Build a map from Integer to List<Character>
        Map<Integer, List<Character>> map = new HashMap<>();
        char start = 'a';
        for (int i = 2; i <= 9; i++) {
            map.put(i, new ArrayList<>());
            for (int j = 0; j < 3; j++) {
                map.get(i).add(start++);
            }
            if (i == 7 || i == 9) {
                map.get(i).add(start++);
            }
        }

        dfs(res, new StringBuilder(), digits, 0, map);
        return res;
    }

    // Could use bfs as well, just poll concatenate and then put back to queue
    private void dfs(List<String> res, StringBuilder sb, String digits, int idx, Map<Integer, List<Character>> map) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }

        // PLEASE!!! Don't use Integer.valueOf('2'), this will not return integer 2
        int value = digits.charAt(idx) - '0';
        if (map.get(value) != null) {
            for (char ch : map.get(value)) {
                sb.append(ch);
                dfs(res, sb, digits, idx + 1, map);
                sb.setLength(sb.length() - 1);
            }
        }
    }
}
