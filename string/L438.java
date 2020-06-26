package string;

import java.util.ArrayList;
import java.util.List;

public class L438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() < p.length()) {
            return res;
        }

        int[] countS = new int[26];
        int[] countP = new int[26];

        for (int i = 0; i < p.length(); i++) {
            countS[s.charAt(i) - 'a']++;
            countP[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (i > 0) {
                countS[s.charAt(i - 1) - 'a']--;
                countS[s.charAt(p.length() + i - 1) - 'a']++;
            }
            if (isAnagram(countS, countP)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean isAnagram(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
