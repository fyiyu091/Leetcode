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
        if (schedule == null || schedule.size() == 0) {
            return res;
        }

        Queue<List<Interval>> minHeap = new PriorityQueue<>((a, b) -> a.get(0).start - b.get(0).start);
        for (List<Interval> list : schedule) {
            minHeap.offer(list);
        }

        List<Interval> list = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            List<Interval> curr = minHeap.poll();
            list.add(curr.get(0));
            curr.remove(curr.get(0));
            if (curr.size() > 0) {
                minHeap.offer(curr);
            }
        }

        // Now the list is sorted
        int prevEnd = list.get(0).end;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).start > prevEnd) {
                res.add(new Interval(prevEnd, list.get(i).start));
                prevEnd = list.get(i).end;
            }
            else {
                prevEnd = Math.max(prevEnd, list.get(i).end);
            }
        }

        return res;
    }
}

