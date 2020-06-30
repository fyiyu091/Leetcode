package tree;

/* Pseudo-palindromic paths in a binary tree
   Return the number of pesudo-palindromic paths going from root node to leaf nodes
   At current level, what kind of information is required, how many
        1
      2
    3   1
  3   1   1
            1
 */
public class L1457 {
    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] res = new int[1];
        dfs(root, new int[10], res);
        return res[0];
    }

    private void dfs(TreeNode curr, int[] counts, int[] res) {
        if (curr == null) {
            return;
        }
        if (curr.left == null && curr.right == null) {
            counts[curr.val]++;
            if (canFormPalindromic(counts)) {
                res[0]++;
            }
            counts[curr.val]--;
            return;
        }

        counts[curr.val]++;
        dfs(curr.left, counts, res);
        dfs(curr.right, counts, res);
        counts[curr.val]--;
    }

    private boolean canFormPalindromic(int[] counts) {
        int odd = 0;
        for (int count : counts) {
            if (count % 2 != 0) {
                odd++;
            }
        }
        return odd <= 1;
    }
}
