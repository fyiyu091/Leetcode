package linkedlist;

import tree.ListNode;

public class L369 {
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return null;
        }

        boolean[] carry = new boolean[1];
        head = helper(head, carry);
        if (carry[0]) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            head = newHead;
        }

        return head;
    }

    private ListNode helper(ListNode curr, boolean[] carry) {
        if (curr == null) {
            carry[0] = true;
            return null;
        }

        curr.next = helper(curr.next, carry);
        if (carry[0]) {
            if (curr.val == 9) {
                curr.val = 0;
                carry[0] = true;
            }
            else {
                curr.val += 1;
                carry[0] = false;
            }
        }
        return curr;
    }
}
