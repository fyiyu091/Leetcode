package dfs;

import java.util.ArrayList;
import java.util.List;

public class L77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0) {
            return res;
        }

        dfs(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> curr, int n, int k, int idx) {
        if (k == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i <= n; i++) {
            curr.add(i);
            dfs(res, curr, n, k - 1, i + 1);
            curr.remove(curr.size() - 1);
        }
        return;
    }
}
