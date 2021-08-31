package tree;

/*
    Split BST
    Define TreeNode[0] is the root of all the values <= target
    TreeNode[1] is the root of all the values > target

    Looking at current root
    1. root.val <= target, split right, the right would return one <= target and one > target
    2. root.val > target, split left, the left would return one <= target and one > target
 */
public class L776 {
    public TreeNode[] splitBST(TreeNode root, int target) {
        TreeNode[] res = new TreeNode[2];
        if (root == null) {
            return res;
        }

        if (root.val <= target) {
            TreeNode[] ret = splitBST(root.right, target);
            res[0] = root;
            root.right = ret[0];
            res[1] = ret[1];
        }
        else {
            TreeNode[] ret = splitBST(root.left, target);
            res[1] = root;
            root.left = ret[1];
            res[0] = ret[0];
        }

        return res;
    }
}
