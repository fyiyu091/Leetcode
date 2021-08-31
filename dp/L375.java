package dp;

public class L375 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return helper(dp, 1, n);
    }

    // Return the minimum amount of money needed
    private int helper(int[][] dp, int left, int right) {
        if (left >= right) {
            return 0;
        }
        if (dp[left][right] > 0) {
            return dp[left][right];
        }

        int res = Integer.MAX_VALUE;
        // Min-Max solution here
        // Also, used recursion to get the left >= right cases
        for (int i = left; i <= right; i++) {
            int tmp = i + Math.max(helper(dp, left, i - 1), helper(dp, i + 1, right));
            res = Math.min(res, tmp);
        }

        dp[left][right] = res;
        return res;
    }
}
