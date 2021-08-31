package tree;

/* LCA of a n-ary tree */

public class L236 {
    public NaryTree lowestCommonAncestor(NaryTree root, NaryTree[] targetNode) {
        if (root == null) {
            return null;
        }
        // If the root equals to any of the node
        for (NaryTree node : targetNode) {
            if (root == node) {
                return root;
            }
        }

        NaryTree tmp = null;
        int count = 0;
        for (NaryTree node : root.childrenNodes) {
            NaryTree returnNode = lowestCommonAncestor(node, targetNode);
            if (returnNode != null) {
                tmp = returnNode;
                count++;
            }
        }

        // How many of the child hits the target?
        // If 0, return null
        // If 1, just return that one
        // If > 1, return root
        if (count <= 1) {
            return tmp;
        }
        else {
            return root;
        }
    }
}
