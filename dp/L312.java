package dp;

/* Burst balloons
*  Search problem
*  How to branch? In the current range choose one int burst and divide the range into two range
*  The tricky part is leave the chosen k to be the last one to burst so that its left and right can be defined
*  dp[i][j] will be the maximum coins in range [i, j]
*  dp[i][j] = Math.max(dp[i][k - 1] + dp[k + 1][j] + burst k) k from [i to j]
*  Special case, k = i or k = j, also, when i == 0, the left of i will be just 1
*                                      when j == len - 1, the right of j will be just 1
*
* */
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
                    dp[i][j] = Math.max(dp[i][j], (k == i ? 0 : dp[i][k - 1]) + (k == j ? 0 : dp[k + 1][j])
                            + nums[k] * (i == 0 ? 1 : nums[i - 1]) * (j == len - 1 ? 1 : nums[j + 1]));
                }
            }
        }
        return dp[0][len - 1];
    }
}
