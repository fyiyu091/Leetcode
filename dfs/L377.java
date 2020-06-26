package dfs;

/* Combination sum IV, find number of possible solutions
   The leetcode workable solution will be using dp */

import java.util.ArrayList;
import java.util.List;

public class L377 {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] res = new int[1];
        dfs(res, new ArrayList<>(), nums, 0, target);
        return res[0];
    }

    private void dfs(int[] res, List<Integer> sol, int[] candidates, int index, int target) {
        if (target == 0) {
            res[0]++;
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            sol.add(candidates[i]);
            dfs(res, sol, candidates, index, target - candidates[i]);
            sol.remove(sol.size() - 1);
        }
        return;
    }
}
