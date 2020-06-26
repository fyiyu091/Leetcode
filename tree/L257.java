package tree;

/* Return all root-to-leaf paths */

import java.util.ArrayList;
import java.util.List;

public class L257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        dfs(res, new StringBuilder(), root);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, TreeNode curr) {
        if (curr == null) {
            return;
        }

        if (curr.left == null && curr.right == null) {
            sb.append(String.valueOf(curr.val));
            res.add(sb.toString());
            return;
        }

        sb.append(curr.val);
        sb.append("->");
        int originLen = sb.length();

        dfs(res, sb, curr.left);
        sb.setLength(originLen);

        dfs(res, sb, curr.right);
    }
}
