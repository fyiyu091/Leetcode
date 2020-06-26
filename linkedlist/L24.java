package linkedlist;

/* Swap nodes in pairs */

import tree.ListNode;

public class L24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = swapPairs(head.next.next);
        ListNode second = head.next;
        second.next = head;
        head.next = node;
        return second;
    }
}
