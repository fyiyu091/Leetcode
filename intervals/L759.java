package intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/* Employee free time */

public class L759 {
    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        Queue<Interval> queue = new PriorityQueue<>((a, b) -> a.start - b.start);
        for (List<Interval> oneSchedule : schedule) {
            for (Interval time : oneSchedule) {
                queue.offer(time);
            }
        }

        List<Interval> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }

        int prevEnd = list.get(0).end;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).start > prevEnd) {
                Interval gap = new Interval(prevEnd, list.get(i).start);
                res.add(gap);
            }
            prevEnd = Math.max(prevEnd, list.get(i).end);
        }

        return res;
    }
}

