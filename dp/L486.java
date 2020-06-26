package dp;

public class L486 {
    public boolean predictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = nums[i];
                }

                int leftTwo = i + 2 > j ? 0 : dp[i + 2][j];
                int rightTwo = i > j - 2 ? 0 : dp[i][j - 2];
                int leftOneRightOne = i + 1 > j - 1 ? 0 : dp[i + 1][j - 1];
                dp[i][j] = Math.max(nums[i] + Math.min(leftTwo, leftOneRightOne), nums[j] + Math.min(leftOneRightOne
                           , rightTwo));
            }
        }

        return dp[0][len - 1] >= sum - dp[0][len - 1];
    }
}
