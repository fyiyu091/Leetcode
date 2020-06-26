package kproblems;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/*
   Find K closest elements, could also sort array by the distance to x, find the first k then sort again to
   generate the results
*/
public class L658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int index = findIndex(arr, x);
        res.add(arr[index]);
        k--;
        int left = index - 1;
        int right = index + 1;
        while (k-- > 0) {
            if (left < 0) {
                res.add(arr[right++]);
            }
            else if (right >= arr.length) {
                res.add(0, arr[left--]);
            }
            else {
                if (Math.abs(arr[right] - x) < Math.abs(arr[left] - x)) {
                    res.add(arr[right++]);
                }
                else {
                    res.add(0, arr[left--]);
                }
            }
        }
        return res;
    }

    private int findIndex(@NotNull int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) return mid;
            else if (arr[mid] < x) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return Math.abs(arr[left] - x) > Math.abs(arr[right] - x) ? right : left;
    }
}
