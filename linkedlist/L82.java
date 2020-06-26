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
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if (prev.next == curr) {
                prev = prev.next;
            }
            else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
