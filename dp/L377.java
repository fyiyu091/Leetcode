package dp;

/* Combination Sum IV
*  Find the number of possible combinations that add up to a positive integer target
*  Search problem, how to branch? target minus any num from nums
*  Status dp[i] is number of possible combinations of i from nums
* */

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
