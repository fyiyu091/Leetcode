package dfs;

/* Combination sum III, all possible combinations of k numbers that add up to number n */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class L216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0) return res;

        dfs(res, new ArrayList<>(), 1, k, n);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int index, int k, int n) {
        if (n == 0 && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (n < 0 || path.size() > k) {
            return;
        }

        for (int i = index; i < 10; i++) {
            path.add(i);
            dfs(res, path, i + 1, k, n - i);
            path.remove(path.size() - 1);
        }
        return;
    }
}
