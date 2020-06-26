package tree;

/* Binary tree longest consecutive sequence */

public class L298 {
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftVal = dfs(root.left);
        int rightVal = dfs(root.right);

        int returnVal = 1;
        if (root.left != null && root.val + 1 == root.left.val) {
            returnVal = leftVal + 1;
        }
        if (root.right != null && root.val + 1 == root.right.val) {
            returnVal = Math.max(returnVal, rightVal + 1);
        }

        max = Math.max(max, returnVal);

        return returnVal;
    }
}
