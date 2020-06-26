package bst;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/*
   try to find if we have absolute difference between nums[i] and nums[j] is at least t
   also, the absolute difference between i and j is k, i.e the index difference between 0 and 3
   is 3 - 0 which is 3
 */
public class AbsoluteGapFinder {
    public static boolean absolutegapFinder(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        // k is each element in nums, v is a set of the index of each element
        // to handle duplicate
        TreeMap<Integer, Set<Integer>> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                if (treeMap.get(nums[i - k]).size() == 1) {
                    treeMap.remove(nums[i - k]);
                }
                else {
                    treeMap.get(nums[i - k]).remove(i - k);
                }
            }

            int upper = nums[i] + t;
            int lower = nums[i] - t;
            if (treeMap.floorKey(lower) != null || treeMap.ceilingKey(upper) != null) {
                return true;
            }
            treeMap.putIfAbsent(nums[i], new HashSet<>());
            treeMap.get(nums[i]).add(i);
        }
        return false;
    }
}
