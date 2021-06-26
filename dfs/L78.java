package dfs;

import java.util.ArrayList;
import java.util.List;

public class L78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        dfs(res, new ArrayList<>(), nums, 0);

        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> curr, int[] nums, int idx) {
        // Why using res.add(curr) would result all empty list?
        // Because it will have all the lists point to the same address
        // Then when the last curr.remove() happens, all the lists will be empty
        res.add(new ArrayList<>(curr));

        for (int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);
            dfs(res, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
