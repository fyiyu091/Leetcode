package dfs;

/* Combination sum II, each number may only be used once */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;

        Arrays.sort(candidates);
        dfs(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int[] candidates, int i, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (i > candidates.length - 1 || target < 0) {
            return;
        }

        // How to branch? add this or not add this
        path.add(candidates[i]);
        dfs(res, path, candidates, i + 1,target - candidates[i]);
        path.remove(path.size() - 1);

        while(i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        dfs(res, path, candidates, i + 1, target);
        return;
    }
}
