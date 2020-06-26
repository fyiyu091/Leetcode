package amazonoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) {
            return null;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                else {
                    return o1[0] - o2[0];
                }
            }
        });

        List<List<Integer>> res = new ArrayList<>();
        int beginStart = intervals[0][0];
        int beginEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int tmpStart = intervals[i][0];
            int tmpEnd = intervals[i][1];
            if (tmpStart <= beginEnd) {
                beginEnd = Math.max(beginEnd, tmpEnd);
            }
            else {
                res.add(Arrays.asList(beginStart, beginEnd));
                beginStart = tmpStart;
                beginEnd = tmpEnd;
            }
        }
        res.add(Arrays.asList(beginStart, beginEnd));
        int[][] results = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            results[i][0] = res.get(i).get(0);
            results[i][1] = res.get(i).get(1);
        }
        return results;
    }
}
