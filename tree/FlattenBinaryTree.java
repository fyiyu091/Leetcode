package tree;

/* Before do this level, need the bottom level all ready */

public class FlattenBinaryTree {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode tmp = root.left;
        if (tmp != null) {
            while (tmp.right != null) {
                tmp = tmp.right;
            }
            tmp.right = root.right;
            root.right = root.left;
        }
        root.left = null;
    }
}
