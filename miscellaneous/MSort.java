package miscellaneous;

public class MSort {
    public void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int[] aux = new int[arr.length];
        helper(arr, 0, arr.length - 1, aux);
    }

    private void helper(int[] arr, int left, int right, int[] aux) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        helper(arr, left, mid, aux);
        helper(arr, mid + 1, right, aux);
        mergeTwo(arr, left, mid, right, aux);
        return;
    }

    private void mergeTwo(int[] arr, int left, int mid, int right, int[] aux) {
        for (int i = left; i <= right; i++) {
            aux[i] = arr[i];
        }

        int leftP = left;
        int rightP = mid + 1;

        while (leftP <= mid && rightP <= right) {
            if (aux[leftP] <= aux[rightP]) {
                arr[left++] = aux[leftP++];
            }
            else {
                arr[left++] = aux[rightP++];
            }
        }

        while (leftP <= mid) {
            arr[left++] = aux[leftP++];
        }

        return;
    }
}
