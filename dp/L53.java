package dp;

/* Maximum subarray */

public class L53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int dp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp > 0) {
                dp = dp + nums[i];
            }
            else {
                dp = nums[i];
            }
            max = Math.max(max, dp);
        }

        return max;
    }
}
