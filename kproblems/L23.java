package kproblems;

/* Merge K sorted lists */

public class L23 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return divideConquer(lists, 0, lists.length - 1);
    }

    private ListNode divideConquer(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode n1 = divideConquer(lists, start, mid);
        ListNode n2 = divideConquer(lists, mid + 1, end);
        return mergeTwo(n1, n2);
    }

    private ListNode mergeTwo(ListNode n1, ListNode n2) {
        if (n1 == null && n2 == null) {
            return null;
        }
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }

        ListNode res = null;
        if (n1.val < n2.val) {
            res = n1;
            res.next = mergeTwo(n1.next, n2);
        }
        else {
            res = n2;
            res.next = mergeTwo(n1, n2.next);
        }
        return res;
    }
}
