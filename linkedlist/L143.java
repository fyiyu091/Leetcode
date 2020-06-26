package linkedlist;

import tree.ListNode;

/* Reorder list
   1 -> 2 -> 3 -> 4 -> 5 to 1 -> 5 -> 2 -> 4 -> 3
 */
public class L143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == null) { // only has one element
            return;
        }

        ListNode next = slow.next;
        slow.next = null;

        next = reverse(next);

        ListNode curr = head;
        while (curr != null && next != null) {
            ListNode nextCurr = curr.next;
            ListNode nextSlow = next.next;
            curr.next = next;
            next.next = nextCurr;
            curr = nextCurr;
            next = nextSlow;
        }

        return;
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
