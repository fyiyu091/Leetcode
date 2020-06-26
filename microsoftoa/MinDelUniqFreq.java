package microsoftoa;

import java.util.HashSet;
import java.util.Set;

public class MinDelUniqFreq {
    public static int minDeletion(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] freqs = new int[26];
        for (char ch : s.toCharArray()) {
            freqs[ch - 'a']++;
        }

        int res = 0;
        Set<Integer> set = new HashSet<>();

        for (int freq : freqs) {
            if (set.add(freq)) {
                continue;
            }
            while (freq != 0 && set.contains(freq)) {
                freq--;
                res++;
            }
            if (freq != 0) {
                set.add(freq);
            }
        }

        return res;
    }
}
