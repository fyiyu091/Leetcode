package string;

/* String transforms into another string */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class L1153 {
    public boolean canConvert(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return true;
        }
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (map.containsKey(str1.charAt(i)) && map.get(str1.charAt(i)) != str2.charAt(i)) {
                return false;
            }
            map.put(str1.charAt(i), str2.charAt(i));
        }

        int size = map.values().size();
        return new HashSet<Character>(map.values()).size() < 26 ? false : true;
    }

    public static void main(String[] args) {
        L1153 test = new L1153();
        test.canConvert("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyzq");
    }
}
