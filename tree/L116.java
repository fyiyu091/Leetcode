package tree;

/* Populating next right pointers in each node */

public class L116 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node leftMost = root;

        while (leftMost.left != null) {
            Node head = leftMost;

            while (head != null) {
                head.left.next = head.right;

                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;
            }

            leftMost = leftMost.left;
        }

        return root;
    }
}
