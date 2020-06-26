package iterator;

import java.util.*;

public class ZigzagIterator {
    private Queue<Iterator<Integer>> queue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (v1 != null && v1.size() != 0) {
            queue.offer(v1.iterator());
        }
        if (v2 != null && v2.size() != 0) {
            queue.offer(v2.iterator());
        }
    }

    public int next() {
        if (!queue.isEmpty()) {
            Iterator<Integer> topList = queue.poll();
            int val = topList.next();
            if (topList.hasNext()) {
                queue.offer(topList);
            }
            return val;
        }
        throw new IllegalStateException();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
