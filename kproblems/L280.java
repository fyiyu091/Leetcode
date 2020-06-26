package kproblems;

/* Wiggle sort
*  nums[0] <= nums[1] <= nums[2] <= nums[3] ...
* */

import java.util.Arrays;

public class L280 {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        Arrays.sort(nums);
        int i = 1;
        int len = nums.length;
        while (i < len) {
            if (i + 1 < len) {
                swap(nums, i, i + 1);
            }
            else {
                break;
            }
            i += 2;
        }
        return;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
