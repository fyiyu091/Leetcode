package array;

import java.util.ArrayList;
import java.util.List;

/* LIS using ArrayList for O(nlogn) time complexity
*  Every point in the arr means that what's the last element of the LIS in the length of the index
*  So the best way is to always update the array to have a increasing
* */

public class L300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        List<Integer> arr = new ArrayList<>();
        for (int n : nums) {
            int idx = findIdx(arr, n);
            // Only two option, either replace the previous or add to the very end
            if (idx == arr.size()) {
                arr.add(n);
            }
            else {
                arr.set(idx, n);
            }
        }
        return arr.size();
    }

    private int findIdx(List<Integer> arr, int n) {
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) < n) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}
