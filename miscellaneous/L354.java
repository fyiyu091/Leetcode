package miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    // Sort ascending, so that when a[0] == b[0] this will not counted as increasing
                    return b[1] - a[1];
                }
                else {
                    return a[0] - b[0];
                }
            }
        });

        return longestIncSeq(envelopes);
    }

    private int longestIncSeq(int[][] envelopes) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < envelopes.length; i++) {
            int idx = findIdx(arr, envelopes[i][1]);
                if (idx == arr.size()) {
                    arr.add(envelopes[i][1]);
                }
                else {
                    arr.set(idx, envelopes[i][1]);
                }
        }
        return arr.size();
    }

    private int findIdx(List<Integer> arr, int n) {
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) < n) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}
