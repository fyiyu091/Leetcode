package slidingwindow;

/* nums contains all positive numbers, whether can find a subarray which sum up to target */

public class SubArraySum {
    public boolean subArraySum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        int start = 0;
        int end = 0;

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
                return true;
            }
        }

        return false;
    }
}
