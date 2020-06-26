package tree;

/* Distribute coins in binary tree, N node with N coins, need each node to have 1 coin */

public class L979 {
    public int distributeCoins(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] sum = new int[1];
        dfs(root, sum);

        return sum[0];
    }

    private int dfs(TreeNode root, int[] sum) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left, sum);
        int right = dfs(root.right, sum);

        sum[0] += Math.abs(left) + Math.abs(right);
        return root.val - 1 + left + right; // Make myself balance first
    }
}
