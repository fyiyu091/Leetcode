package tree;

/* Maximum binary tree, construct the tree with the root is the maximum
   number in the array
 */
public class L654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int maxIdx = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        TreeNode node = new TreeNode(nums[maxIdx]);
        node.left = helper(nums, left, maxIdx - 1);
        node.right = helper(nums, maxIdx + 1, right);
        return node;
    }
}
