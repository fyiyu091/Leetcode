package tree;

/*
    A good node is defined as that from root to the node, all the nodes
    are having smaller values than the node
 */
public class L1448 {
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode curr, int val) {
        if (curr == null) {
            return 0;
        }

        int left = dfs(curr.left, Math.max(curr.val, val));
        int right = dfs(curr.right, Math.max(curr.val, val));

        return curr.val >= val ? left + right + 1 : left + right;
    }
}
