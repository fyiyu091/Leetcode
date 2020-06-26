package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || newInterval == null || newInterval.length != 2){
            return new int[0][0];
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (end < newInterval[0]) {
                list.add(Arrays.asList(start, end));
            }
            else if (start > newInterval[1]) {
                list.add(Arrays.asList(newInterval[0], newInterval[1]));
                newInterval[0] = start;
                newInterval[1] = end;
            }
            else {
                newInterval[0] = Math.min(newInterval[0], start);
                newInterval[1] = Math.max(newInterval[1], end);
            }
        }
        // The key is adding the previous interval when at the current interval
        list.add(Arrays.asList(newInterval[0], newInterval[1]));

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = list.get(i).get(0);
            res[i][1] = list.get(i).get(1);
        }

        return res;
    }
}
