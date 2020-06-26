package array;

import java.util.HashSet;
import java.util.Set;

/*
  Longest consecutive sequence
  Find the length of the longest consecutive elements sequence
  100,4,200,1,3,2
  Answer: 4 (1,2,3,4)
 */
public class L128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        int res = 1;
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int count = 0;
            while (set.contains(num)) {
                count++;
                num++;
            }
            res = Math.max(res, count);
        }

        return res;
    }
}
