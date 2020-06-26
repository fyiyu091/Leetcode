package tree;

/* Sum root to leaf numbers
          1
        2   3

   res = 12 + 13 = 25
 */
public class L129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] res = new int[1];
        dfs(res, 0, root);

        return res[0];
    }

    private void dfs(int[] res, int num, TreeNode curr) {
        if (curr == null) {
            return;
        }
        num = num * 10 + curr.val;
        if (curr.left == null && curr.right == null) {
            res[0] += num;
            return;
        }

        dfs(res, num, curr.left);
        dfs(res, num, curr.right);
    }
}
