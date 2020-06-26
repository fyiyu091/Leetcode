package linkedlist;

/* Merge k sorted lists */

import tree.ListNode;

public class L23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        int mid = left + (right - left) / 2;
        ListNode leftHead = helper(lists, left, mid);
        ListNode rightHead = helper(lists, mid + 1, right);
        return merge(leftHead, rightHead);
    }

    private ListNode merge(ListNode leftHead, ListNode rightHead) {
        if (leftHead == null) {
            return rightHead;
        }
        if (rightHead == null) {
            return leftHead;
        }

        ListNode head = null;
        if (leftHead.val < rightHead.val) {
            head = leftHead;
            head.next = merge(leftHead.next, rightHead);
        }
        else {
            head = rightHead;
            head.next = merge(leftHead, rightHead.next);
        }

        return head;
    }
}
