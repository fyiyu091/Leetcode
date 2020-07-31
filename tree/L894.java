package tree;

/* All possible full binary trees */

import java.util.ArrayList;
import java.util.List;

public class    L894 {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N % 2 == 0) {
            return res;
        }
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        for (int i = 1; i < N - 1; i += 2) {
            List<TreeNode> leftNodes = allPossibleFBT(i);
            List<TreeNode> rightNodes = allPossibleFBT(N - i - 1);
            for (TreeNode left : leftNodes) {
                for (TreeNode right : rightNodes) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        return res;
    }
}
