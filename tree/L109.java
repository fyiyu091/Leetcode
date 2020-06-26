package tree;

/* Convert sorted list to binary search tree */

public class L109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);
    }

    private TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode curr = new TreeNode(slow.val);
        curr.left = toBST(head, slow);
        curr.right = toBST(slow.next, tail);
        return curr;
    }

    /*
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode res = new TreeNode(slow.val);
        ListNode second = slow.next;
        prev.next = null;
        res.left = sortedListToBST(head);
        res.right = sortedListToBST(second);
        return res;
    }
     */
}
