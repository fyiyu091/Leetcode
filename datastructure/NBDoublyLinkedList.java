package datastructure;

public class NBDoublyLinkedList<T> {
    class ListNode<T> {
        private T val;
        private ListNode prev;
        private ListNode next;

        ListNode(T val) {
            this.val = val;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size;

    NBDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private void addHead(T t) {
        ListNode newHead = new ListNode(t);
        if (head == null) {
            tail = newHead;
        }
        else {
            head.next = newHead;
            newHead.prev = head;
        }
        head = newHead;
        size++;
    }

    private void addTail(T t) {
        ListNode newTail = new ListNode(t);
        if (tail == null) {
            head = newTail;
        }
        else {
            tail.prev = newTail;
            newTail.next = tail;
        }
        tail = newTail;
        size++;
    }

    // Remove the element at the specific index
    private T remove(int idx) {
        if (head == null) {
            throw new IllegalArgumentException("The list is empty");
        }
        if (idx < 0 || idx > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        // now the idx is valid
        // if we only have one element
        if (head.prev == null) {
            T ret = (T) head.val;
            head = null;
            tail = null;
            size = 0;
            return ret;
        }

        // we have more than one element
        int k = idx;
        ListNode curr = tail;
        while (k-- > 0) {
            curr = curr.next;
        }

        T ret = (T) curr.val;

        // now we need to remove this curr
        // curr is tail
        if (curr.prev == null) {
            tail = curr.next;
            tail.prev = null;
        }
        // curr is head
        else if (curr.next == null) {
            head = curr.prev;
            head.next = null;
        }
        // curr is in the middle
        else {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }

        curr.prev = null;
        curr.next = null;
        size--;
        return ret;
    }
}
