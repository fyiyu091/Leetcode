package string;

import java.util.HashSet;
import java.util.Set;

public class L345 {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        Set<Character> vowels = new HashSet<>();
        char[] tmp = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for (char ch : tmp) {
            vowels.add(ch);
        }

        char[] res = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!vowels.contains(res[left])) {
                left++;
            }
            else if (!vowels.contains(res[right])) {
                right--;
            }
            else {
                char swap = res[right];
                res[right] = res[left];
                res[left] = swap;
                left++;
                right--;
            }
        }

        return String.valueOf(res);
    }
}
