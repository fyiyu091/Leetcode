package linkedlist;

import tree.ListNode;

public class L61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        k %= len;
        if (k == 0) {
            return head;
        }

        /*
         The way to find the Nth from the end is to use fast to reach out N
         And slow fast moving right at the same pace until fast hits the end
        */

        ListNode fast = head;
        while (k-- > 0 && fast != null) {
            fast = fast.next;
        }

        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}
