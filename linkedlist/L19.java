package linkedlist;

/* Remove Nth node from end of list */

import tree.ListNode;

public class L19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;

        while (n-- > 0 && fast != null) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }

        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode tmp = slow.next.next;
        slow.next.next = null;
        slow.next = tmp;

        return head;
    }
}
