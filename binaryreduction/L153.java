package binaryreduction;

/* Find minimum in rotated sorted array
*  [2,1]
*     l         l
*   r
*   m
* */

public class L153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int val = nums[0];
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < val) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return nums[left];
    }
}
