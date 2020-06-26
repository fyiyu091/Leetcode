package string;

/* Strobogrammatic number
*  number that looks the same when rotated 180 degrees
* */

import java.util.HashMap;
import java.util.Map;

public class L246 {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('0', '0');

        int len = num.length();
        int left = 0, right = len - 1;
        while (left <= right) {
            char lChar = num.charAt(left);
            char rChar = num.charAt(right);
            if (!map.containsKey(lChar) || !map.containsKey(rChar)) {
                return false;
            }
            if (map.get(lChar) != rChar || map.get(rChar) != lChar) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
