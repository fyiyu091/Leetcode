package linkedlist;

import tree.ListNode;

public class L86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;
        ListNode smaller = null;
        ListNode larger = null;
        ListNode sHead = null;
        ListNode lHead = null;
        while (curr != null) {
            if (curr.val < x) {
                if (smaller == null) {
                    smaller = new ListNode(curr.val);
                    sHead = smaller;
                }
                else {
                    ListNode tmp = new ListNode(curr.val);
                    smaller.next = tmp;
                    smaller = smaller.next;
                }
            }
            else {
                if (larger == null) {
                    larger = new ListNode(curr.val);
                    lHead = larger;
                }
                else {
                    ListNode tmp = new ListNode(curr.val);
                    larger.next = tmp;
                    larger = larger.next;
                }
            }
            curr = curr.next;
        }
        if (sHead == null) {
            return lHead;
        }
        else {
            smaller.next = lHead;
            return sHead;
        }
    }
}
