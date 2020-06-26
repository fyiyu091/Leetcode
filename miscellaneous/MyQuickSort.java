package miscellaneous;

import java.util.Arrays;

public class MyQuickSort {
    public void myQuickSort(int[] input) {
        if (input == null || input.length == 0) {
            return;
        }

        int left = 0;
        int right = input.length - 1;
        quickSort(input, left, right);
    }

    private void quickSort(int[] input, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(input, left, right);
        quickSort(input, left, pivot - 1);
        quickSort(input, pivot + 1, right);
    }

    // Pivot the element at right and partition the array into two parts
    private int partition(int[] input, int left, int right) {
        int pivotVal = input[right];
        // [left, i] is smaller than pivotVal, (i, j) is equal or larger than pivotVal, [j, right] is unchecked area
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (input[j] < pivotVal) {
                swap(input, ++i, j);
            }
        }
        swap(input, ++i, right);
        return i;
    }

    private void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    public static void main(String[] args) {
        MyQuickSort ms = new MyQuickSort();
        int[] a = {1, 2, 5, 9, 23, 3, -1, 2};
        ms.myQuickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
