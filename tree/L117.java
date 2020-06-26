package tree;

/* Assume current level's next pointer is established, use this to construct the next level's connection */

public class L117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node leftMost = root;
        Node head = null;
        Node prev = null;

        // This while is for between level
        while (leftMost != null) {
            // This while is for within level
            while (leftMost != null) {
                if (leftMost.left != null) {
                    if (prev == null) {
                        head = leftMost.left;
                    }
                    else {
                        prev.next = leftMost.left;
                    }
                    prev = leftMost.left;
                }
                if (leftMost.right != null) {
                    if (prev == null) {
                        head = leftMost.right;
                    }
                    else {
                        prev.next = leftMost.right;
                    }
                    prev = leftMost.right;
                }
                leftMost = leftMost.next;
            }
            leftMost = head;
            head = null;
            prev = null;
        }
        return root;
    }
}
