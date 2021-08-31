package linkedlist;

import tree.ListNode;


/*  d -> 1 -> 2 -> 3 -> 3 -> 4 -> 4
              p
                                   c
 */

public class L82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode curr = head;
        prev.next = head;
        while (curr != null) {
            // Making sure curr's next is a different number
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            // If prev.next is curr means that curr should be kept
            if (prev.next == curr) {
                prev = prev.next;
            }
            // Otherwise, we should skip curr and just jumps to curr.next
            // We don't want to advance prev yet, because the curr.next might have duplicates as well
            else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
