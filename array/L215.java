package array;

/* Kth largest element in an array */

public class L215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // Kth largest means len - k + 1 smallest
        int kth = nums.length - k + 1;

        return search(nums, 0, nums.length - 1, kth);
    }

    private int search(int[] nums, int left, int right, int kth) {
        if (left == right) {
            return nums[left];
        }

        int p = partition(nums, left, right);
        int rank = p - left + 1;
        if (rank == kth) {
            return nums[p];
        }
        else if (rank < kth) {
            return search(nums, p + 1, right, kth - rank);
        }
        else {
            return search(nums, left, p - 1, kth);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivotIdx = right, pivotVal = nums[right];
        // [left, i] all smaller, (i, j) all larger or equal, [j, right - 1] all unchecked
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivotVal) { // if equal, will not swap
                swap(nums, ++i, j);
            }
        }
        swap(nums, ++i, pivotIdx);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
