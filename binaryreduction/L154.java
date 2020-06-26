package binaryreduction;

/* Find minimum in rotated sorted array II, contain duplicates */

public class L154 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            }
            else if (nums[mid] > nums[right]) {
                left = mid;
            }
            else {
                right--;
            }
        }
        return nums[left] < nums[right] ? nums[left] : nums[right];
    }
}
