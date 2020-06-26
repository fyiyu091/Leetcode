package bst;

import java.util.*;

/* Delete the node with the given key in the BST */

public class L450 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) {
            if (root.left != null && root.right != null) {
                TreeNode rightSmallest = findSmallest(root.right);
                root.right = deleteNode(root.right, rightSmallest.val);
                root.val = rightSmallest.val;
            }
            else {
                root = root.left == null ? root.right : root.left;
            }
        }
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    private TreeNode findSmallest(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return findSmallest(root.left);
    }
}
