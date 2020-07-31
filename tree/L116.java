package tree;

/* Populating next right pointers in each node */

public class L116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node head = root;
        while (head.left != null) { // Guaranteed to not having lower level
            Node curr = head;

            while (curr != null) {
                curr.left.next = curr.right;

                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }

                curr = curr.next;
            }
            head = head.left; // No need to use another variable to save head because head = head.left will do
        }

        return root;
    }
}
