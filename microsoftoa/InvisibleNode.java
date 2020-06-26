package microsoftoa;

import tree.TreeNode;

public class InvisibleNode {
    public int countInvisibleNode(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        if (root.val >= max) {
            count++;
            max = root.val;
        }

        return count + dfs(root.left, max) + dfs(root.right, max);
    }
}
