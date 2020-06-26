package tree;

/* Recover binary search tree */

public class L99 {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode[] needSwap = new TreeNode[2];
        find(root, new TreeNode[1], needSwap);
        int tmp = needSwap[0].val;
        needSwap[0].val = needSwap[1].val;
        needSwap[1].val = tmp;
        return;
    }

    private void find(TreeNode root, TreeNode[] prev, TreeNode[] needSwap) {
        if (root == null) {
            return;
        }
        find(root.left, prev, needSwap);
        if (prev[0] != null && prev[0].val > root.val) {
            if (needSwap[0] == null) {
                needSwap[0] = prev[0];
            }
            needSwap[1] = root;
        }
        prev[0] = root;
        find(root.right, prev, needSwap);
        return;
    }
}
