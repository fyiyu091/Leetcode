package microsoftoa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxNetworkRank {
    public int maxNetworkRank(int[] A, int[] B, int N) {
        if (A == null || A.length == 0 || B == null || B.length == 0) {
            return 0;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], new HashSet<>());
            }
            map.get(A[i]).add(B[i]);
            if (!map.containsKey(B[i])) {
                map.put(B[i], new HashSet<>());
            }
            map.get(B[i]).add(A[i]);
        }

        int max = 0;
        for (int i = 0; i < A.length; i++) {
            // The road between is counted twice
            int curr = map.get(A[i]).size() + map.get(B[i]).size() - 1;
            max = Math.max(max, curr);
        }

        return max;
    }
}
