package tree;

/*
    The next level needs the info from this level
    Also, the level needs the return from next level to make a decision
 */
public class L98 {
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }

    private boolean valid(TreeNode root, Integer upper, Integer lower) {
        if (root == null) {
            return true;
        }

        if (upper != null && root.val >= upper) {
            return false;
        }

        if (lower != null && root.val <= lower) {
            return false;
        }

        return valid(root.left, root.val, lower) && valid(root.right, upper, root.val);
    }
//    public boolean isValidBST(TreeNode root) {
//        TreeNode[] prev = new TreeNode[1];
//        return isValidBST(root, prev);
//    }
//
//    private boolean isValidBST(TreeNode root, TreeNode[] prev) {
//        if (root == null) {
//            return true;
//        }
//
//        if (!isValidBST(root.left, prev)) {
//            return false;
//        }
//        if (prev[0] != null && prev[0].val >= root.val) {
//            return false;
//        }
//        prev[0] = root;
//        return isValidBST(root.right, prev);
//    }
}
