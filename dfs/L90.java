package dfs;

/* Subsets II, input contains duplicates, return List shouldn't contain duplicates */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> sol, int[] nums, int level) {
        if (level == nums.length) {
            res.add(new ArrayList<>(sol));
            return;
        }

        sol.add(nums[level]);
        dfs(res, sol, nums, level + 1);
        sol.remove(sol.size() - 1);

        while (level + 1 < nums.length && nums[level] == nums[level + 1]) {
            level++;
        }
        dfs(res, sol, nums, level + 1);
        return;
    }
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (nums == null || nums.length == 0) {
//            return res;
//        }
//        Arrays.sort(nums);
//        dfs(res, new ArrayList<>(), nums, 0);
//        return res;
//    }
//
//    private void dfs(List<List<Integer>> res, List<Integer> sol, int[] nums, int index) {
//        res.add(new ArrayList<>(sol));
//
//        for (int i = index; i < nums.length; i++) {
//            if (i > index && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            sol.add(nums[i]);
//            dfs(res, sol, nums, i + 1);
//            sol.remove(sol.size() - 1);
//        }
//        return;
//    }
}
