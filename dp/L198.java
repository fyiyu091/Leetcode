package dp;

/* House Robber */

public class L198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int max = Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            for (int j = i - 2; j >= 0; j--) {
                max = Math.max(max, dp[j]);
            }
            if (nums[i] + max > dp[i - 1]) {
                dp[i] = nums[i] + max;
            }
            else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[nums.length - 1];
    }
}
