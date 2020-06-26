package tree;

/* Binary tree maximum path sum */

public class L124 {
    private int max;
    public int maxPathSum(TreeNode root) {
        max = root.val;
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftVal = helper(root.left);
        int rightVal = helper(root.right);

        max = Math.max(Math.max(0, leftVal) + Math.max(0, rightVal) + root.val, max);
        return Math.max(0, Math.max(leftVal, rightVal)) + root.val;
    }
}
