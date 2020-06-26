package dp;

/* Combination Sum IV */

public class L377 {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[target + 1];
        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i < num) {
                    continue;
                }
                else if (i == num) {
                    dp[i]++;
                }
                else {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }
}
