package array;

/* 3 Sum Closest
*  dist = target - num1 - num2 - num3
* */

import java.util.Arrays;

public class L16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int dist = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int num = target - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (Math.abs(num - nums[left] - nums[right]) < dist) {
                    dist = Math.abs(num - nums[left] - nums[right]);
                    res = sumThree(nums[i], nums[left], nums[right]);
                }
                if (nums[left] + nums[right] > num) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }

        return res;
    }

    private int sumThree(int i, int j, int k) {
        return i + j + k;
    }
}
