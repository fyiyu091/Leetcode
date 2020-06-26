package tree;

/* Count Uni-value subtrees
   Uni-value subtrees means all nodes of the subtree
   have the same value
 */

public class L250 {
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] count = new int[1];
        dfs(root, 0, count);
        return count[0];
    }

    // If root is a univalue subtree with target integer value
    // target is from parent
    private boolean dfs(TreeNode root, int target, int[] count) {
        if (root == null) {
            return true;
        }

        boolean left = dfs(root.left, root.val, count);
        boolean right = dfs(root.right, root.val, count);

        if (!left || !right) {
            return false;
        }

        // Since left child and right child are univalue tree with curr value
        count[0]++;

        // return to its parent
        return root.val == target;
    }
}
