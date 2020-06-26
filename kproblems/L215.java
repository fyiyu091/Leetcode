package kproblems;

/* Find the kth largest element in an array
*  Convert kth largest to kth smallest
* */

public class L215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int kth = nums.length - k + 1;

        return helper(nums, 0, nums.length - 1, kth);
    }

    private int helper(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[start];
        }

        int p = partition(nums, start, end);
        int rank = p - start + 1;
        if (rank == k) {
            return nums[p];
        }
        if (rank < k) {
            return helper(nums, p + 1, end, k - rank);
        }
        else {
            return helper(nums, start, p - 1, k);
        }
    }

    // based on the end value, partition the nums into two parts
    private int partition(int[] nums, int start, int end) {
        int val = nums[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (nums[j] < val) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, ++i, end);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
