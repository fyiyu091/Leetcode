package array;

/* Remove duplicates from sorted array in place, return the len
*
*  0 1 2 1 1 2 2
*      s
*                f
*
* */

public class L26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0;
        int len = nums.length;

        for (int fast = 1; fast < len; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }
}
