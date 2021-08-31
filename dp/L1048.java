package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L1048 {
    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int res = 1;
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (String word : words) {
            map.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                if (map.containsKey(sb.toString()) && map.get(sb.toString()) + 1 > map.get(word)) {
                    map.put(word, map.get(sb.toString()) + 1);
                }
            }
            res = Math.max(res, map.get(word));
        }

        return res;
    }
}
