package datastructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
    Need to retrieve the first unique integer in the queue

    2 3 5 5

    why can't use Set, because for an value, we need to know if it's in the queue, seen once, seen twice three status
 */
public class FirstUnique {
    private Map<Integer, Boolean> seen;
    private Queue<Integer> queue;
    public FirstUnique(int[] nums) {
        this.seen = new HashMap<>();
        this.queue = new LinkedList<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        return queue.isEmpty() ? -1 : queue.peek();
    }

    public void add(int value) {
        if (seen.containsKey(value)) {
            seen.put(value, true); // true means this value has seen twice
            while (!queue.isEmpty() && seen.get(queue.peek())) { // Need to poll() all the way
                queue.poll();
            }
        }
        else {
            seen.put(value, false);
            queue.offer(value);
        }
    }
}
