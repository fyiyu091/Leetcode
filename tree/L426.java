package tree;

/* Convert binary search tree to sorted doubly linked list */

public class L426 {
    Node prev = null;
    Node head = null;
    public Node treeToDoublyList(Node root) {
        inOrder(root);
        if (prev != null && head != null) {
            prev.right = head;
            head.left = prev;
        }
        return head;
    }

    private void inOrder(Node root) {
        if (root == null) return;

        inOrder(root.left);
        if (prev == null) {
            head = root;
        }
        else {
            prev.right = root;
        }
        root.left = prev;
        prev = root;

        inOrder(root.right);
        return;
    }
}
