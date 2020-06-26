package slidingwindow;

/* Given an all positive int array, whether having two non-overlap subarray to make their sum both equal to target */

public class TwoNonOverLap {
    public boolean subArraySum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        int start = 0;
        int end = 0;
        int count = 0;

        while (end < nums.length) {
            while (sum < target && end < nums.length) {
                sum += nums[end];
                end++;
            }
            while (sum > target && start <= end) {
                sum -= nums[start];
                start++;
            }
            if (sum == target) {
                if (count == 1) {
                    return true;
                }
                count++;
                sum = 0;
                start = end;
            }
        }

        return false;
    }
}
