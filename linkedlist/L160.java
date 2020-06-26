package linkedlist;

/* Intersection of two linked lists */

import tree.ListNode;

public class L160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode currA = headA;
        ListNode currB = headB;

        while (currA != currB) {
            currA = currA == null ? headB : currA.next;
            currB = currB == null ? headA : currB.next;
        }

        return currB;
    }
}
