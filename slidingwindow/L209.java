package slidingwindow;

/* Minimum size subarray sum that is larger than s */

public class L209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int end = 0;
        int start = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int len = nums.length;

        while (end < len) {
            sum += nums[end];
            while (sum >= s) {
                int currLen = end - start + 1;
                if (currLen < res) {
                    res = currLen;
                }
                sum -= nums[start++];
            }
            end++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
