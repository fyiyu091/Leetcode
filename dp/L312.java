package dp;

/* Burst balloons */
public class L312 {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                for (int k = i; k <= j; k++) {
                    // left part is 0 when k == 0, right part is 0 when k == len - 1
                    dp[i][j] = Math.max(dp[i][j], (k == 0 ? 0 : dp[i][k - 1]) + (k == len - 1 ? 0 : dp[k + 1][j])
                            + nums[k] * (i == 0 ? 1 : nums[i - 1]) * (j == len - 1 ? 1 : nums[j + 1]));
                }
            }
        }
        return dp[0][len - 1];
    }
}
