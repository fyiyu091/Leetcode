package string;

import java.util.HashMap;
import java.util.Map;

public class L242 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
        }

        for (int n : map.values()) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
}
