package string;

import java.util.HashMap;
import java.util.Map;

public class L1525 {
    public int numSplits(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 0;
        Map<Character, Integer> rightMap = new HashMap<>();
        Map<Character, Integer> leftMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            rightMap.put(s.charAt(i), rightMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length() - 1; i++) {
            char leftChar = s.charAt(i);
            leftMap.put(leftChar, leftMap.getOrDefault(leftChar, 0) + 1);
            // Remove it from the rightMap
            int numOfLeftChar = rightMap.get(leftChar);
            numOfLeftChar--;
            if (numOfLeftChar == 0) {
                rightMap.remove(leftChar);
            }
            else {
                rightMap.put(leftChar, numOfLeftChar);
            }
            // If both have the same unique letters would add 1 to the res
            if (leftMap.size() == rightMap.size()) {
                res++;
            }
        }

        return res;
    }
}
