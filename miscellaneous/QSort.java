package miscellaneous;

import java.util.Random;

public class QSort {
    public void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        helper(arr, 0, arr.length - 1);
        return;
    }

    private void helper(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = partitionTwo(arr, left, right);
        helper(arr, left, mid - 1);
        helper(arr, mid + 1, right);
        return;
    }

    private int partitionTwo(int[] arr, int left, int right) {
        Random rand = new Random();
        int mid = rand.nextInt(right - left) + left;
        swap(arr, mid, right);
        int val = arr[right];

        int leftP = left;
        int rightP = right - 1;
        while (leftP <= rightP) {
            if (arr[leftP] <= val) {
                leftP++;
            }
            else if (arr[rightP] > val) {
                rightP--;
            }
            else {
                swap(arr, leftP++, rightP--);
            }
        }
        swap(arr, leftP, mid);
        return leftP;
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
        return;
    }
}
