package array;

/* Assume the nums contains duplicate and is always valid */

import java.util.Arrays;

public class ThreeSumAllTriplet {
    public int threeSumAllTriplet(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] == target) {
                    sum++;
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    start++;
                    end--;
                }
                else if (nums[i] + nums[start] + nums[end] < target) {
                    start++;
                }
                else {
                    end--;
                }
            }

            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return sum;
    }

}
