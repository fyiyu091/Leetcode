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

        // The max binary tree sum with the root node at the root
        // So The max doesn't necessary happens when the root node is at the top root
        max = Math.max(Math.max(0, leftVal) + Math.max(0, rightVal) + root.val, max);
        // Can only return one side up to the upper level
        // The max is calculated during the previous max process
        return Math.max(0, Math.max(leftVal, rightVal)) + root.val;
    }
}
