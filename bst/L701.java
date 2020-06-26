package bst;

import com.sun.source.tree.Tree;
import tree.TreeNode;
/* Insert into a binary search tree */

public class L701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.val > val) {
            TreeNode left = insertIntoBST(root.left, val);
            root.left = left;
            return root;
        }
        else {
            TreeNode right = insertIntoBST(root.right, val);
            root.right = right;
            return root;
        }
    }
}
