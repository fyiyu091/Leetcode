package kproblems;

/* Using quick selection to get the top k frequent elements
*  The partition is based on the frequency
* */

import java.util.HashMap;
import java.util.Map;

public class TopKElement {
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        if (nums == null || nums.length == 0) {
            return res;
        }

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        int[] arr = new int[frequencyMap.size()];
        int i = 0;
        for (int key : frequencyMap.keySet()) {
            arr[i++] = key;
        }

        // Now need to find the kth most frequency
        // Before kth is higher or equal frequency
        // After kth is smaller frequency
        quickSelection(arr, 0, arr.length - 1, k);

        for (int idx = 0; idx < k; idx++) {
            res[idx] = arr[idx];
        }

        return res;
    }

    private void quickSelection(int[] arr, int left, int right, int k) {
        if (left == right) {
            return;
        }

        int p = partition(arr, left, right);
        int rank = p - left + 1;
        if (rank == k) {
            return;
        }
        else if (rank < k) {
            quickSelection(arr, p + 1, right, k - rank);
        }
        else {
            quickSelection(arr, left, p - 1, k);
        }
    }

    private int partition(int[] arr, int left, int right) {
        // The last element's frequency
        int val = frequencyMap.get(arr[right]);
        int i = left - 1;
        for (int j = left; j <= right - 1; j++) {
            if (frequencyMap.get(arr[j]) >= val) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, ++i, right);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
