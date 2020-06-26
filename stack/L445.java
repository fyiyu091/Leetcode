package stack;

import tree.ListNode;

import java.util.Stack;

public class L445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        while (curr1 != null) {
            s1.push(curr1.val);
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            s2.push(curr2.val);
            curr2 = curr2.next;
        }

        ListNode res = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int num1 = s1.isEmpty() ? 0 : s1.pop();
            int num2 = s2.isEmpty() ? 0 : s2.pop();
            int val = num1 + num2 + carry;
            if (val >= 10) {
                carry = 1;
                val %= 10;
            }
            else {
                carry = 0;
            }

            ListNode head = new ListNode(val);
            head.next = res;
            res = head;
        }

        if (carry == 1) {
            ListNode node = new ListNode(1);
            node.next = res;
            res = node;
        }

        return res;
    }
}
