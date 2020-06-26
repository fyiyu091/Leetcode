package kproblems;

/* Wiggle sort II, valley and peak
*  nums[0] < nums[1] < nums[2] < nums[3] ...
 * */

public class L324 { //TODO
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // Now find the median
        int median = findMedian(nums);

    }

    // use quick selection to find the median of the input array
    // 1,2,3 will be 2
    // 1,2,3,4 will be 2 as well
    private int findMedian(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int len = nums.length;
        int k = (len - 1) / 2;

        return helper(nums, 0, len - 1, k);
    }

    // Find kth element start from left
    private int helper(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }

        int idx = partition(nums, left, right);
        int rank = idx - left + 1;
        if (rank == k) {
            return nums[idx];
        }
        else if (rank < k) {
            return helper(nums, idx + 1, right, k - rank);
        }
        else {
            return helper(nums, left, idx - 1, k);
        }
    }

    // partition nums and return the idx that partition the array
    private int partition(int[] nums, int left, int right) {
        int val = nums[right];
        // [left, i] smaller, (i, j) equals or larger, [j, right - 1] unchecked
        int i = left - 1;
        for (int j = left; j <= right - 1; j++) {
            if (nums[j] < val) {
                swap(nums, ++i, j);
            }
        }
        swap(nums, ++i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
