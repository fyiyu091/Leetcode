package tree;

public class L543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] max = new int[1];
        max[0] = 0;
        helper(root, max);
        return max[0];
    }

    private int helper(TreeNode root, int[] max) {
        if (root == null) {
            return -1;
        }

        int left = helper(root.left, max);
        int right = helper(root.right, max);

        max[0] = Math.max(left + right + 2, max[0]);

        return Math.max(left, right) + 1;
    }
}
