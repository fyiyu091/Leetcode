package linkedlist;

import tree.ListNode;

/* Remove duplicates from sorted list, keep one*/

public class L83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            // slow keeps at the first occurrence of a number
            // fast keeps moving to the right
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;

        return head;
    }
}
