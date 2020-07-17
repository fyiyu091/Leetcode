package tree;

import java.util.ArrayList;
import java.util.List;

public class L113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        dfs(res, new ArrayList<>(), root, sum);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, TreeNode curr, int sum) {
        if (curr == null) {
            return;
        }

        if (curr.left == null && curr.right == null && sum == curr.val) {
            path.add(curr.val);
            res.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        path.add(curr.val);
        dfs(res, path, curr.left, sum - curr.val); // could set it back but it will be adding curr.val again, so no need to
        dfs(res, path, curr.right, sum - curr.val);
        path.remove(path.size() - 1);
    }
}
