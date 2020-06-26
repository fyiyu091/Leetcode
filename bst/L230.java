package bst;

import tree.TreeNode;

/* Find Kth smallest element in the BST */

public class L230 {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        int[] info = new int[] {k, root.val};
        inOrder(root, info);

        return info[1];
    }

    private void inOrder(TreeNode root, int[] info) {
        if (root == null) {
            return;
        }

        inOrder(root.left, info);

        if (info[0] == 1) {
            info[1] = root.val;
            info[0]--;
            return;
        }
        info[0]--;

        inOrder(root.right, info);
    }
}
