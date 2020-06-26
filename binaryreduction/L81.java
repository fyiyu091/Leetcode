package binaryreduction;

/* Search in rotated sorted array II */

public class L81 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            else if (nums[mid] < nums[right]) {
                if (nums[mid] > target || nums[right] < target) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else if (nums[mid] > nums[right]) {
                if (nums[left] > target || nums[mid] < target) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            else {
                    right--;
            }
        }
        return false;
    }
}
