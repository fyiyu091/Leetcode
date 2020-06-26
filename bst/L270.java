package bst;

import tree.TreeNode;

/* Closest binary search tree value */

public class L270 {
    public int closestValue(TreeNode root, double target) {
        if (root == null) throw new IllegalArgumentException();
        int res = root.val;

        while (root != null) {
            if (Math.abs(root.val - target) < 0.000001) {
                return root.val;
            }
            else if (root.val > target) {
                if (Math.abs(root.val - target) < Math.abs(res - target)) {
                    res = root.val;
                }
                root = root.left;
            }
            else {
                if (Math.abs(root.val - target) < Math.abs(res - target)) {
                    res = root.val;
                }
                root = root.right;
            }
        }

        return res;
    }
}
