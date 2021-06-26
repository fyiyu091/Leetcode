package array;

import java.util.Arrays;

/*
        k = 2
        1 1 1 3 3 5 5 5 5 5 6 6 6
                          s
                                f
 */

public class DedupLeaveK {
    public int[] dedupLeaveK(int[] nums, int k) {
        if (nums == null || nums.length <= k) {
            return nums;
        }

        // Starting from k index, both pointing at the same index
        // Why slow can't be 0, because the first k must be the same
        // Slow and fast starting at the same point
        int slow = k;
        int fast = k;
        while (fast < nums.length) {
            // If equal, need to write it down
            if (nums[slow - k] != nums[fast]) {
                nums[slow++] = nums[fast++];
            }
            // If not equal, would skip for fast
            else {
                fast++;
            }
        }

        int[] res = new int[slow - 1];
        for (int i = 0; i < slow - 1; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        DedupLeaveK test = new DedupLeaveK();
        int[] nums = {1,1,8,8,8,2,3,3,3,3,4,5,1,1};

        System.out.println(Arrays.toString(test.dedupLeaveK(nums, 3)));
    }
}
