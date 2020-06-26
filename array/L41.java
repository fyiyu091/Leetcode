package array;

/* Find the first missing positive
    1 2 3 4 5 6
idx 0 1 2 3 4 5
   Put the nums in range [1, nums.length] on designated position
   E.g. 3 4 -1 1
        1 4 -1 3
* */

public class L41 {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            // One swap then we finalize one number
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}
