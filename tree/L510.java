package tree;

/* Inorder successor in BST II
   Given the node instead of the root
 */
public class L510 {
    class Node {
        int val;
        Node left;
        Node right;
        Node parent;
    }

    public Node inorderSuccessor(Node node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            Node curr = node.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }
        else {
            Node curr = node;
            while (curr != null) {
                if (curr.val > node.val) {
                    return curr;
                }
                curr = curr.parent;
            }
        }
        return null;
    }
}
