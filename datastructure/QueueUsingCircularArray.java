package datastructure;

public class QueueUsingCircularArray<T> {
    private static final int INITIAL_CAP = 10;
    private T[] arr;
    private int head;
    private int tail;
    private int size;
    private int cap;

    QueueUsingCircularArray(int cap) {
        this.arr = (T[]) new Object[cap];
        this.cap = cap;
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public boolean offer(T t) {
        if (this.size == this.cap) {
            return false;
        }

        arr[tail] = t;
        tail = (tail + 1) % arr.length;
        size++;
        return true;
    }

    public T poll() {
        if (this.size == 0) {
            return null;
        }

        T ret = arr[head];
        arr[head] = null;
        head = (head + 1) % arr.length;
        size--;
        return ret;
    }
}
