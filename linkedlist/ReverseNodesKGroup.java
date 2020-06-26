package linkedlist;

import tree.ListNode;

public class ReverseNodesKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;
        ListNode prev = null;
        int count = k;
        while (curr != null && count > 0) {
            prev = curr;
            curr = curr.next;
            count--;
        }
        if (count > 0) {
            return head;
        }
        else {
            ListNode retNode = reverseKGroup(curr, k);
            prev.next = null;
            reverse(head);
            head.next = retNode;
            return prev;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
