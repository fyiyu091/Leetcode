package array;

/* Two sum less than K */

import java.util.Arrays;

public class L1099 {
    public int twoSumLessThanK(int[] A, int K) {
        if (A == null || A.length == 0) {
            return -1;
        }

        Arrays.sort(A);

        int left = 0;
        int right = A.length - 1;
        int res = -1;
        while (left < right) {
            int diff = K - (A[left] + A[right]);
            if (diff > 0) {
                res = Math.max(res, A[left] + A[right]);
                left++;
            }
            else {
                right--;
            }
        }

        return res;
    }
}
