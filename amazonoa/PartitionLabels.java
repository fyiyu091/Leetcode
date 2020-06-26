package amazonoa;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }

        // Get the last occurrence idx of the char
        int[] lastIdx = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIdx[S.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int maxEnd = 0;
        for (int i = 0; i < S.length(); i++) {
            maxEnd = Math.max(lastIdx[S.charAt(i) - 'a'], maxEnd);
            if (i == maxEnd) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }

        return res;
    }
}
