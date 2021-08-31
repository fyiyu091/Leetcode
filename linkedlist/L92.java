package linkedlist;

import tree.ListNode;

/* Reverse a linked list from position m to n */
public class L92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode beforeReverse = null;
        ListNode curr = head;
        while (m-- > 1) {
            beforeReverse = curr;
            curr = curr.next;
            n--;
        }

        ListNode originHead = curr;

        ListNode prev = beforeReverse;
        // Recursively will not work in this case, unless add a search status
        // Basically, reverse n times
        while (n-- > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // if m == 1, then we would just use prev after the reverse as the head
        if (beforeReverse != null) {
            beforeReverse.next = prev;
        }
        else {
            head = prev;
        }

        originHead.next = curr;

        return head;
    }
}
