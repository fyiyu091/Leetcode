package slidingwindow;

import java.util.Arrays;

/*
   Find two non-overlapping sub-arrays and the sum of the lengths of the two is minimum
   All the element in the array is positive number
   3,1,1,1,5,1,2,1 target is 3
   ans wil be 3 from [3] and [2,1]
   sliding window to find all possible sub-array
   how to handle the non-overlap situation?
   use an array to store the mini length subarray ending at or before at the index that sum is target
   in this case, once we find a valid subarray, we can check whether we can update the final res

   The key is minLenSubArray stores the minLen ending at or before at the index that sum is target
 */
public class L1477 {
    public int minSumOfLengths(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int start = 0;
        int len = arr.length;
        int[] minLenSubArray = new int[len];
        Arrays.fill(minLenSubArray, Integer.MAX_VALUE);
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int tmpMinLen = Integer.MAX_VALUE;

        for (int end = 0; end < len; end++) {
            sum += arr[end];
            while (sum > target) {
                sum -= arr[start++];
            }
            if (sum == target) {
                if (start > 0 && minLenSubArray[start - 1] != Integer.MAX_VALUE) {
                    res = Math.min(res, minLenSubArray[start - 1] + (end - start + 1));
                }
                tmpMinLen = Math.min(tmpMinLen, end - start + 1);
            }
            // update the minLenSubArray[end] either we find a better one or just use the previous
            minLenSubArray[end] = tmpMinLen;
        }

        return res == Integer.MAX_VALUE ? - 1 : res;
    }
}
