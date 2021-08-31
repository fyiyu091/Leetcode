package intervals;

/* Meeting room II */
/* Sort all left and right, be careful about the tie */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Another way is to using a minHeap to store endtime, if the coming starttime is >= endtime, poll
   then add curr starttime into the minHeap, count the size of the minHeap at the end
   with this approach, every moment the required number of rooms are true
 */
public class  L253 {
    class Point implements Comparable<Point> {
        private int val;
        private boolean isLeft;
        Point(int val, boolean isLeft) {
            this.val = val;
            this.isLeft = isLeft;
        }

        @Override
        public int compareTo(Point other) {
            if (this.val != other.val) {
                return this.val - other.val;
            }
            else {
                return this.isLeft == true ? 1 : -1;
            }
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) {
            return 0;
        }

        List<Point> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Point(intervals[i][0], true));
            list.add(new Point(intervals[i][1], false));
        }

        Collections.sort(list);
        int count = 0;
        int max = 0;
        for (Point p : list) {
            if (p.isLeft) {
                count++;
            }
            else {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
