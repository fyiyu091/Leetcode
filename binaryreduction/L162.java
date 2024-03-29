package binaryreduction;


/*
  [1,2,1,3,5,6,4]
               l
             r
             m
 */
public class L162 {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0 || nums[mid] >= nums[mid - 1]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return right;
    }
}
