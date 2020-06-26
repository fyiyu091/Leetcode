package string;

import java.util.HashMap;
import java.util.Map;

/* Isomorphic strings */

public class L205 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (!map1.containsKey(a)) {
                map1.put(a, b);
            }

            if (!map2.containsKey(b)) {
                map2.put(b, a);
            }

            if (map1.get(a) != b || map2.get(b) != a) {
                return false;
            }
        }
        return true;
    }
}
