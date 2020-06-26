package binaryreduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        };

        Arrays.sort(envelopes, comp);

        List<int[]> list = new ArrayList<>();
        for (int[] envelope : envelopes) {
            int idx = findIdx(envelope, list);
            if (idx == list.size()) {
                list.add(envelope);
            }
            else {
                list.set(idx, envelope);
            }
        }

        return list.size();
    }

    private int findIdx(int[] envelope, List<int[]> list) {
        int val = envelope[1];
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid)[1] < envelope[1]) { // If we are looking for non-decreasing subsequence, need to change to <= here
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}
