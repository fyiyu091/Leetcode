package tree;

/* Find sum of left leaves */

public class L404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root, false);
    }

    private int dfs(TreeNode curr, boolean isLeft) {
        if (curr == null) {
            return 0;
        }

        if (curr.left == null && curr.right == null && isLeft) {
            return curr.val;
        }

        return dfs(curr.left, true) + dfs(curr.right, false);
    }
}
