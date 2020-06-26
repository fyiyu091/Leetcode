package miscellaneous;

import java.util.Arrays;

public class MergeSort {
    public void mergeSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int[] helper = new int[nums.length];
        sort(nums, 0, nums.length - 1, helper);
        return;
    }

    private void sort(int[] nums, int left, int right, int[] helper) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(nums, left, mid, helper);
        sort(nums, mid + 1, right, helper);
        merge(nums, left, mid, right, helper);
        return;
    }

    private void merge(int[] nums, int left, int mid, int right, int[] helper) {
        for (int i = left; i <= right; i++) {
            helper[i] = nums[i];
        }
        int leftStart = left;
        int rightStart = mid + 1;

        while (leftStart <= mid && rightStart <= right) {
            if (helper[leftStart] <= helper[rightStart]) {
                nums[left++] = helper[leftStart++];
            }
            else {
                nums[left++] = helper[rightStart++];
            }
        }
        while (leftStart <= mid) {
            nums[left++] = helper[leftStart++];
        }
        return;
    }
}
