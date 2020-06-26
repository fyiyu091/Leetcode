package binaryreduction;

public class L410 {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        long left = 0;
        long right = 0; // right will be the sum of all the elements
        for (int n : nums) {
            if (n > left) {
                left = n;
            }
            right += n;
        }

        // check how many subarray the nums needs to divide into to have every subarray sum <= mid
        // if the number of subarray is smaller than m, meaning mid is too large
        // if the number of subarray is larger than m, meaning mid is too small
        long res = right;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            // try to find how many group can be divided to have each group sum <= mid
            int count = 1;
            int i = 0;
            int tmpSum = 0;
            while (i < nums.length) {
                if (tmpSum + nums[i] > mid) {
                    count++;
                    tmpSum = nums[i];
                }
                else {
                    tmpSum += nums[i];
                }
                i++;
            }
            if (count <= m) {
                res = Math.min(res, mid);
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return (int) left;
    }
}
