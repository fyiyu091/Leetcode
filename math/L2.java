package math;

import tree.ListNode;

public class L2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int carry = 0;
        ListNode curr = dummy;

        while (l1 != null || l2 != null || carry == 1) {
            int v1 = (l1 == null) ? 0 : l1.val;
            int v2 = (l2 == null) ? 0 : l2.val;

            int value = v1 + v2 + carry;
            if (value / 10 != 0) {
                carry = 1;
                value = value % 10;
            }
            else {
                carry = 0;
            }
            ListNode node = new ListNode(value);
            curr.next = node;
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummy.next;
    }
}
