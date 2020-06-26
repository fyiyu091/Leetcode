package miscellaneous;

/* Merge sort divide and conquer idea
*  Sort in place
* */

import java.util.Arrays;

public class MyMergeSort {
    public void myMergeSort(int[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException();
        }

        // need to divide
        int len = input.length;
        int[] helper = new int[len];
        mergeSort(input, 0, len - 1, helper);
    }

    private void mergeSort(int[] input, int left, int right, int[] helper) {
        if (left == right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(input, left, mid, helper);
        mergeSort(input, mid + 1, right, helper);
        mergeTwo(input, left, mid, right, helper);
    }

    private void mergeTwo(int[] input, int left, int mid, int right, int[] helper) {
        for (int i = left; i <= right; i++) {
            helper[i] = input[i];
        }

        // using the helper array to sort from [left, mid] and [mid + 1, right]
        int leftP = left;
        int rightP = mid + 1;
        while (leftP <= mid && rightP <= right) {
            if (helper[leftP] <= helper[rightP]) {
                input[left++] = helper[leftP++];
            }
            else {
                input[left++] = helper[rightP++];
            }
        }
        while (leftP <= mid) {
            input[left++] = helper[leftP++];
        }
    }

    public static void main(String[] args) {
        MyMergeSort ms = new MyMergeSort();
        int[] a = {1, 2, 5, 9, 23, 3, -1, 2};
        ms.myMergeSort(a);
        System.out.println(Arrays.toString(a));
    }
}
