package tree;

/* Given an integer n, generate all unique BST that store values 1 ... n */

import java.util.ArrayList;
import java.util.List;

/* Generate all structurally unique BST that stores 1 ... n
*  To do this level, needs the return from the lower levels
*  Any subtree would be bst as well
* */
public class L95 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        return dfs(1, n);
    }

    private List<TreeNode> dfs(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }

        for (int i = left; i <= right; i++) {
            List<TreeNode> l = dfs(left, i - 1);
            List<TreeNode> r = dfs(i + 1, right);
            for(TreeNode nodeLeft : l) {
                for (TreeNode nodeRight : r) {
                    TreeNode root = new TreeNode(i);
                    root.left = nodeLeft;
                    root.right = nodeRight;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
