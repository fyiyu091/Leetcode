package linkedlist;

import tree.ListNode;

/*
   dummy 4 2 1 3
         c
           n
 */
public class L147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            if (next != null && next.val < curr.val) {
                curr.next = curr.next.next;
                prev = dummy;
                ListNode tmp = prev.next; // Be careful not using head again, because the head can be changed by inserting new node
                while (tmp != null && tmp.val < next.val) {
                    prev = tmp;
                    tmp = tmp.next;
                }
                prev.next = next;
                next.next = tmp;
            }
            else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
