package tree;

public class L230 {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            throw new IllegalArgumentException();
        }

        Integer[] res = new Integer[] {null, k};
        inOrder(root, res);
        return res[0];
    }

    private void inOrder(TreeNode root, Integer[] res) {
        if (root == null) {
            return;
        }

        inOrder(root.left, res);

        if (res[1] == 1) {
            res[1]--;
            res[0] = root.val;
            return;
        }
        res[1]--;

        inOrder(root.right, res);
    }
}
