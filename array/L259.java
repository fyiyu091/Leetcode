package array;

/* 3Sum smaller, find the number of index triplets sum to target */

import java.util.Arrays;

public class L259 {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = target - nums[i];
                if (nums[start] + nums[end] < sum) {
                    res += end - start;
                    // why not end--?, because we added the end-- solution to the res already
                    start++;
                }
                else {
                    end--;
                }
            }
        }

        return res;
    }
}
