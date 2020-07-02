package dp;

/* Given non-empty array containing only positive integers, find if the array can be partitioned
   into two subsets such that the sum of elements in both subsets is equal
   [1,5,11,5] can be partitioned to [1,5,5] and [11]
   how to branch? Whether can pick element from array to add up to sum / 2
   search status: dp[i] means whether add add to dp[i]
   dp[i][j] means from 0 to i of nums array, whether we can find subset to add up to j
 */
public class L416 {
    public boolean canPartition(int[] nums) {
        if (nums == null) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        sum /= 2;

        // Try to find whether we can pick elements out to add up to sum
        // dp[i][j] means at index of i whether can find subset to add up to j
        // dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j]
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]]; // dp i and nums i is offset by one
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[nums.length][sum];
    }
}
