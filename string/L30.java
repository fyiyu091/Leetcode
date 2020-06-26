package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Substring with concatenation of all words */

public class L30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }

        int num = words.length;
        int size = words[0].length();

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - num * size; i++) {
            int k = num;
            int j = i;
            Map<String, Integer> copy = new HashMap<>(map);
            while (k > 0) {
                String str = s.substring(j, j + size);
                if (!copy.containsKey(str) || copy.get(str) < 1) {
                    break;
                }
                copy.put(str, copy.get(str) - 1);
                j = j + size;
                k--;
            }
            if (k == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
