package string;

import java.util.HashMap;
import java.util.Map;

/*
    Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
    Output: "eeebffff"
 */
public class L833 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            map.put(indices[i], i);
        }

        StringBuilder res = new StringBuilder();
        int len = s.length();
        int i = 0;

        // i is the idx of the String s
        while (i < len) {
            if (!map.containsKey(i)) {
                res.append(s.charAt(i++));
                continue;
            }
            // Need to check if need to replace
            int idx = map.get(i);

            if (!s.substring(i, i + sources[idx].length()).equals(sources[idx])) {
                res.append(s.charAt(i++));
                continue;
            }

            i += sources[idx].length();
            res.append(targets[idx]);
        }

        return res.toString();
    }
}
