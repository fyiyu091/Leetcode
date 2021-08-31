package kproblems;

import tree.ListNode;

/*
  Reverse nodes in k-group, if the number of nodes is not a multiple of k then left-out
  in the end should remain as it is
*/
public class L25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;

        ListNode curr = head;
        for (int i = 0; i < k - 1; i++) {
            curr = curr.next;
            if (curr == null) {
                return head;
            }
        }

        ListNode next = curr.next;
        // Cut off the chain
        curr.next = null;
        ListNode newHead = reverse(head);
        // Reverse the next section with the k-group
        head.next = reverseKGroup(next, k);
        return newHead;
    }

    private ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
