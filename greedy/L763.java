package greedy;

import java.util.ArrayList;
import java.util.List;

/* Partition labels
   partition the string into as many as possible so that each letter appears in at most one part
   Return the list of integers representing the size of these parts

   abcd
   The goal is to partition as many as possible
   a b c d, we can have 4 parts
   a b a c d, we can have 3 parts, abc, c, d
   a b c d a, we can only have 1 part, abcda

   First, we can find the last occurrence of the element
   Then loop from left to right, for each element find its last occurrence
   And move the index to the next of the last occurrence

   qiejxqfnqceocmy, qiejxqfnqceoc, m, y
                    qiejxqfnqce

 */
public class L763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }

        int[] lastIdx = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIdx[S.charAt(i) - 'a'] = i;
        }

        int idx = 0;
        int len = S.length();
        int maxInRange = 0;
        while (idx < len) {
            char ch = S.charAt(idx);
            int endIdx = lastIdx[ch - 'a'];
            maxInRange = endIdx;
            for (int i = idx; i <= maxInRange; i++) {
                // Consistently update the maxRange while looping over the element
                maxInRange = Math.max(maxInRange, lastIdx[S.charAt(i) - 'a']);
            }
            res.add(maxInRange - idx + 1);
            idx = maxInRange + 1;
        }

        return res;
    }
}
