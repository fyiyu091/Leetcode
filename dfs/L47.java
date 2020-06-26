package dfs;

/* Permutations II, with duplicates */

import java.util.*;

public class L47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        dfs(res, nums, 0);

        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int level) {
        if (level == nums.length) {
            List<Integer> sol = new ArrayList<>();
            for (int n : nums) {
                sol.add(n);
            }
            res.add(sol);
            return;
        }

        /* Because the swap change the sort order, the i > level && nums[i] == nums[i - 1] will not work
           Have to use set to jump duplicate
         */
        Set<Integer> set = new HashSet<>();
        for (int i = level; i < nums.length; i++) {
            if (set.add(nums[i])) {
                swap(nums, level, i);
                dfs(res, nums, level + 1);
                swap(nums, level, i);
            }
        }
        return;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
