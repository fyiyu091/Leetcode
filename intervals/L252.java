package intervals;

/* Meeting room I */

import java.util.Arrays;

public class L252 {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) {
            return true;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                return false;
            }
            start = intervals[i][0];
            end = intervals[i][1];
        }

        return true;
    }
}
