package bst;

import java.util.TreeSet;

/* Whether the absolute difference between nums[i] and nums[j] is at most t and the
   absolute difference between i and j is at most k
 */
public class L220 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // Corner case

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }

            Long val = set.floor((long) nums[i] + t);
            if (val != null && val >= (nums[i] - t)) {
                return true;
            }
            set.add((long) nums[i]);
        }
        return false;
    }
}
