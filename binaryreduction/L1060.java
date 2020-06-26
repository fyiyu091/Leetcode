package binaryreduction;

/* Missing element in sorted array */

public class L1060 {
    public int missingElement(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int missingNum = nums[mid] - nums[left] - (mid - left);
            if (missingNum < k) {
                left = mid;
                k -= missingNum;
            }
            else {
                right = mid;
            }
        }
        return nums[left] + k < nums[right] ? nums[left] + k : nums[right] + k - (nums[right] - nums[left] - 1);
    }
}
