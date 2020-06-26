package linkedlist;

/* Reverse Nodes in k-Group */

import tree.ListNode;

public class L25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;
        int count = k - 1;
        while (curr != null && count-- > 0) {
            curr = curr.next;
        }
        if (curr != null) {
            ListNode nextHead = curr.next;
            curr.next = null;
            ListNode newHead = reverse(head);
            ListNode retHead = reverseKGroup(nextHead, k);
            head.next = retHead;
            return newHead;
        }
        else {
            return head;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
