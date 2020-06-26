package array;

/* Remove duplicates from sorted array, duplicates appeared at most twice
*  [1, 1, 2, 3, 2, 3]
*               s
*                  f
*
* */

public class L80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 2;
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow++] = nums[fast];
            }
        }

        return slow;
    }
}
