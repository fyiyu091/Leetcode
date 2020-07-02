package dp;

/* House Robber II
   The difference is that the first house is the neighbor of the last house
   So if the first house is robbed, the last can't be robbed
   2 3 2
   the first 2 and the last 2 can not be both robbed because they are neighbor
   How to handle this case?
   Separate into two case
   Here is the index:
      0 1 2 3 ... len - 1
   case1: 0 1 2 3 ... len - 2
   case2: 1 2 3 4 ... len - 1
   Pick the max out of case1 and case2
 */
public class L213 {
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

        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    private int helper(int[] nums, int left, int right) {
        int len = right - left + 1;
        int[] dp = new int[len];
        dp[len - 1] = nums[right];
        dp[len - 2] = Math.max(nums[right], nums[right - 1]);
        for (int i = len - 3; i >= 0; i--) { // when i = len - 3, right - 2, when i = len - 1, right
            dp[i] = Math.max(nums[right - ((len - 1) - i)] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }
}
