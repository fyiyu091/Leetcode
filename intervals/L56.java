package intervals;

/* Merge intervals */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) {
            return new int[0][0];
        }

        List<List<Integer>> list = new ArrayList<>();
        Comparator<int[]> comp = new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };

        Arrays.sort(intervals, comp);

        int tmpStart = intervals[0][0];
        int tmpEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if (currStart <= tmpEnd) {
                // cannot add into the list yet
                tmpEnd = Math.max(tmpEnd, currEnd);
            }
            else {
                list.add(Arrays.asList(tmpStart, tmpEnd));
                tmpStart = currStart;
                tmpEnd = currEnd;
            }
        }

        list.add(Arrays.asList(tmpStart, tmpEnd));

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = list.get(i).get(0);
            res[i][1] = list.get(i).get(1);
        }

        return res;
    }
}
