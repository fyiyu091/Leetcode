package tree;

public class L549 {
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = {1};
        helper(root, max);
        return max[0];
    }

    private int[] helper(TreeNode root, int[] max) {
        if (root == null) {
            return new int[] {0, 0};
        }

        int inc = 1, dec = 1;

        if (root.left != null) {
            int[] leftVal = helper(root.left, max);
            if (root.val == root.left.val + 1) {
                inc = leftVal[0] + 1;
            }
            else if (root.val == root.left.val - 1) {
                dec = leftVal[1] + 1;
            }
        }

        if (root.right != null) {
            int[] rightVal = helper(root.right, max);
            if (root.val == root.right.val + 1) {
                inc = Math.max(inc, rightVal[0] + 1);
            }
            else if (root.val == root.right.val - 1) {
                dec = Math.max(dec, rightVal[1] + 1);
            }
        }

        max[0] = Math.max(max[0], dec + inc - 1);

        return new int[] {inc, dec};
    }
}
