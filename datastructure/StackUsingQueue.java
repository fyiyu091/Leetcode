package datastructure;

import java.util.LinkedList;
import java.util.Queue;

/*
    Using two queues, when pop,
 */
public class StackUsingQueue<T> {
    private Queue<T> q1;
    private Queue<T> q2;
    private int size;

    public StackUsingQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(T t) {
        if (!q1.isEmpty()) {
            q1.offer(t);
        }
        else {
            q2.offer(t);
        }
    }

    public T pop() {
        if (!q1.isEmpty()) {
            while (q1.size() != 1) {
                q2.offer(q1.poll());
            }
            return q1.poll();
        }
        else {
            while (q2.size() != 1) {
                q2.offer(q2.poll());
            }
            return q2.poll();
        }
    }

}
