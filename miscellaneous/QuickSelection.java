package miscellaneous;

/* Find Kth smallest element in an unsorted array, avg/exp O(n), worst case O(n^2) */

public class QuickSelection {
    public int quickSelection(int[] nums, int k) {
        if (nums.length < k) {
            throw new IllegalArgumentException();
        }

        return search(nums, 0, nums.length - 1, k);
    }

    private int search(int[] nums, int left, int right, int k) {
        if (left >= right) {
            return nums[left];
        }

        // p is idx, meaning p element is smaller
        int p = partition(nums, left, right);
        // based on left, what's the rank
        int rank = p - left + 1;
        if (rank == k) {
            return nums[p];
        }
        if (rank < k) {
            // can not just use p because p is based on left
            return search(nums, p + 1, right, k - rank);
        }
        else {
            return search(nums, left, p - 1, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        // [left, i] all smaller, (i, j) all larger or equals, [j, right - 1] unchecked
        // The above condition always holds at the start or end of the loop
        int pivotIdx = right, pivotVal = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivotVal) {
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
