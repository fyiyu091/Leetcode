package tree;

/* LCA of a n-ary tree */

public class L236 {
    public NaryTree lowestCommonAncestor(NaryTree root, NaryTree[] targetNode) {
        if (root == null) {
            return null;
        }
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

        if (count <= 1) {
            return tmp;
        }
        else {
            return root;
        }
    }
}
