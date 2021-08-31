package array;

import java.util.Arrays;

/*
    Minimum difference between largest and smallest value in three moves
    0,1,1,4,6,6,6
    1,5,6,14,15
    0,1,5,10,14
    2,2,2,3,4,4,5
    20,75,81,82,95
    Remove the smallest three or the largest three
    1. Remove 3 left, 0 right
    2. Remove 2 left, 1 right
    3. Remove 1 left, 2 right
    4. Remove 0 left, 3 right
 */
public class L1509 {
    public int minDifference(int[] nums) {
        if (nums == null || nums.length <= 3) {
            return 0;
        }

        int res = 0;
        Arrays.sort(nums);
        return Math.min(Math.min(nums[nums.length - 4] - nums[0], nums[nums.length - 3] - nums[1]),
                Math.min(nums[nums.length - 2] - nums[2], nums[nums.length - 1] - nums[3]));
    }
}
