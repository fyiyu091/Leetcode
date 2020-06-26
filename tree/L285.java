package tree;

public class L285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        TreeNode[] res = new TreeNode[2];
        helper(root, p, res);
        return res[1];
    }

    private void helper(TreeNode root, TreeNode p, TreeNode[] res) {
        if (root == null) {
            return;
        }

        helper(root.left, p, res);
        if (res[0] == p) {
            res[1] = root;
        }
        res[0] = root;
        helper(root.right, p, res);
    }
}
