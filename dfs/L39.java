package dfs;

/* Combination sum */

import java.util.ArrayList;
import java.util.List;

public class L39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        dfs(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }

    // Still need the index variable, otherwise, we will have duplicate [2,2,3] and [2,3,2]
    private void dfs(List<List<Integer>> res, List<Integer> sol, int[] candidates, int index, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(sol));
            return;
        }

        if (target < 0) {
            return;
        }

        // How to branch? add who
        for (int i = index; i < candidates.length; i++) {
            sol.add(candidates[i]);
            dfs(res, sol, candidates, i, target - candidates[i]);
            sol.remove(sol.size() - 1);
        }
        return;
    }
}
