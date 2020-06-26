package miscellaneous;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        sort(nums, 0, nums.length - 1);
        return;
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partitionTwo(nums, left, right);
        sort(nums, left, pivot - 1);
        sort(nums, pivot + 1, right);
        return;
    }

    private int partitionTwo(int[] nums, int left, int right) {
        Random rand = new Random();
        int index = left + rand.nextInt(right - left + 1);
        int indexVal = nums[index];
        swap(nums, index, right);
        int leftIdx = left;
        int rightIdx = right - 1;
        while (leftIdx <= rightIdx) {
            if (nums[leftIdx] <= indexVal) {
                leftIdx++;
            }
            else if (nums[rightIdx] > indexVal) {
                rightIdx--;
            }
            else {
                swap(nums, leftIdx++, rightIdx--);
            }
        }
        swap(nums, leftIdx, right);
        return leftIdx;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
        return;
    }
}
