package tree;

/* Assume current level's next pointer is established, use this to construct the next level's connection
* */

public class L117 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node curr = root;
        Node head = null;
        Node prev = null;

        while (curr != null) {
            while (curr != null) {
                if (curr.left != null) {
                    if (prev == null) {
                        head = curr.left;
                    }
                    else {
                        prev.next = curr.left;
                    }
                    prev = curr.left;

                }
                if (curr.right != null) {
                    if (prev == null) {
                        head = curr.right;
                    }
                    else {
                        prev.next = curr.right;
                    }
                    prev = curr.right;
                }
                curr = curr.next;
            }
            curr = head;
            head = null;
            prev = null;
        }
        return root;
    }
}
