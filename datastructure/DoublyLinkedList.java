package datastructure;

/* Support CRUD */

public class DoublyLinkedList<T> {
    private class ListNode<T> {
        T val;
        ListNode next;
        ListNode prev;
        ListNode(T val) {
            this.val = val;
        }
    }

    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addTail(T val) {
        ListNode newTail = new ListNode(val);
        if (tail == null) {
            head = newTail;
        }
        else {
            tail.next = newTail;
            newTail.prev = tail;
        }
        tail = newTail;
        size++;
    }

    public void addHead(T val) {
        ListNode newHead = new ListNode(val);
        if (head == null) {
            tail = newHead;
        }
        else {
            head.prev = newHead;
            newHead.next = head;
        }
        head = newHead;
        size++;
    }

    public T get(int idx) {
        if (head == null || idx < 0) {
            throw new IllegalArgumentException();
        }
        if (idx > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        ListNode<T> curr = head;
        int k = idx;
        while (k-- > 0) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void remove(int idx) {
        if (head == null || idx < 0) {
            throw new IllegalArgumentException();
        }
        if (idx > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        ListNode<T> curr = head;
        int k = idx;
        while (k-- > 0) {
            curr = curr.next;
        }
        if (curr.next == null && curr.prev == null) {
            head = null;
            tail = null;
            size = 0;
            return;
        }
        if (curr.next == null) {
            curr.prev.next = null;
            // Need to change tail
        }
        else if (curr.prev == null) {
            curr.next.prev = null;
            // Need to change head
        }
        else {
            curr.next.prev = curr.prev;
            curr.prev.next = curr.next;
        }
        curr.prev = null;
        curr.next = null;
        size--;
        return;
    }
}
