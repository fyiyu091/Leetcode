package datastructure;

public class QueueUsingLinkedList<T> {
    private class ListNode<T> {
        private T t;
        private ListNode next;
        private ListNode(T t) {
            this.t = t;
            this.next = null;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    public QueueUsingLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void offer(T t) {
        ListNode node = new ListNode(t);
        if (tail == null) {
            tail = node;
            head = tail;
        }
        else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T poll() {
        if (size < 1) {
            throw new IllegalArgumentException();
        }
        ListNode popHead = head;
        if (size == 1) {
            tail = null;
            head = null;
        }
        else {
            ListNode tmp = head.next;
            head.next = null;
            head = tmp;
        }
        size--;
        return (T) popHead.t;
    }
}
