package bitoperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Repeated DNA sequences */

public class L187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return res;
        }

        // .... ...XX, only the last two digits is needed
        Map<Character, Integer> convertMap = new HashMap<>();
        convertMap.put('A', 0);
        convertMap.put('C', 1);
        convertMap.put('G', 2);
        convertMap.put('T', 3);

        Map<Integer, Boolean> checkMap = new HashMap<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            num <<= 2;
            num |= convertMap.get(s.charAt(i));
            num &= 0x000FFFFF;
            if (i < 9) {
                continue;
            }

            if (checkMap.get(num) == null) { //The first time seeing the number
                checkMap.put(num, false);
            }
            else if (checkMap.get(num) == false) { //The second time seeing the number
                res.add(s.substring(i - 9, i + 1));
                checkMap.put(num, true);
            }
        }
        return res;
    }

}
