package datastructure;

import java.util.EmptyStackException;

public class StackUsingLinkedList<T> {
    class ListNode<T> {
        private T t;
        private ListNode next;
        ListNode(T t) {
            this.t = t;
            this.next = null;
        }
    }

    private ListNode<T> head;
    private int size;

    public StackUsingLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void push(T t) {
        ListNode newHead = new ListNode(t);
        newHead.next = head;
        head = newHead;
    }

    public T pop() {
        if (head == null) {
            throw new EmptyStackException();
        }
        ListNode popHead = head;
        head = head.next;
        popHead.next = null;
        return (T) popHead.t;
    }
}
