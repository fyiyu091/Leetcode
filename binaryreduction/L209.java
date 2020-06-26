package binaryreduction;

/* Minimum size subarray sum
   E.g.         [2,3,1,2,4,3]
   Prefix Sum   [2,5,6,8,12,15]
   For every prefix sum that has >= s value, target is sum - s
   Need to find the last index that's smaller or equals to sum - s
   nlogn solution, need to use prefix sum and binary reduction
*/


public class L209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] prefixSum = new int[len];
        // build the prefixSum array
        for (int i = 0; i < len; i++) {
            prefixSum[i] = i == 0 ? nums[i] : prefixSum[i - 1] + nums[i];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (prefixSum[i] >= s) {
                int target = prefixSum[i] - s;
                int left = find(prefixSum, target);
                res = Math.min(res, i - left);
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private int find(int[] prefixSum, int target) {
        int left = 0;
        int right = prefixSum.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (prefixSum[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return right;
    }
}
