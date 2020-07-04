package dp;

import java.util.Arrays;

/*
   Find the minimum steps you have to take to jump to the end
   [2,3,1,1,4]
   jump to index 1 (value 3), then takes 3 step to jump to the last index

   dp[i] means the minimum jump from i to the end
   dp[i] is min(dp[j], dp[i])  i + 1 <= j <= nums[i] + i
   2,3,1,1,4

   2 1 2 1 0
 */
public class L45 {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, len);
        dp[len - 1] = 0;

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len && j <= i + nums[i]; j++) {
                dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }

        return dp[0];
    }
}
