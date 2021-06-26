package kproblems;

/* Find the kth largest element in an array
*  Convert kth largest to kth smallest
* */

public class L215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        // kth largest is the length - k + 1 smallest
        int kth = nums.length - k + 1;

        return helper(nums, 0, nums.length - 1, kth);
    }

    private int helper(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return nums[start];
        }

        // Find a p index that lefts are all smaller and rights are all larger
        int p = partition(nums, start, end);
        // Find out how large is p
        //   2 3 4 p 6 -> p is 4th smallest which is 5 - 2 + 1 = 4, rank is 4th
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
