package microsoftoa;

import java.util.Arrays;

public class MaxChunkToSort {
    public int findChunks(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int res = 0;
        int originalSum = 0;
        int copySum = 0;
        int[] copyNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copyNums);
        for (int i = 0; i < nums.length; i++) {
            copySum += copyNums[i];
            originalSum += nums[i];
            if (copySum == originalSum) {
                res++;
            }
        }

        return res;
    }
}
