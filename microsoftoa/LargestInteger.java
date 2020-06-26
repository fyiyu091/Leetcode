package microsoftoa;

import java.util.HashSet;
import java.util.Set;

public class LargestInteger {
    public int largestInteger(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;

        boolean containsLargest = false;
        for (int n : nums) {
            if (set.contains(-n)) {
                max = Math.max(max, Math.abs(n));
                containsLargest = true;
            }
            set.add(n);
        }

        return containsLargest ? max : 0;
    }
}
