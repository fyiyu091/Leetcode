package greedy;

import java.util.HashSet;
import java.util.Set;

public class L1647 {
    public int minDeletions(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        int deletion = 0;
        Set<Integer> freq = new HashSet<>();
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0 && freq.contains(count[i])) {
                count[i]--;
                deletion++;
            }
            freq.add(count[i]);
        }

        return deletion;
    }
}
