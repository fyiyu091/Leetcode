package tree;

/* Flatten binary tree to LinkedList */

public class L114 {
    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);
        TreeNode right = root.right;
        TreeNode left = root.left;
        root.left = null;
        root.right = left;
        while (root.right != null) {
            root = root.right;
        }
        root.right = right;
        return;
    }
}
