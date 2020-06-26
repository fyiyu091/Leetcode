package array;

import java.util.Arrays;
import java.util.Comparator;

/* Largest number
   The special case will be [0, 0] should return 0 instead of 00
 */
public class L179 {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                long tmp1 = Long.valueOf(String.valueOf(o1) + String.valueOf(o2));
                long tmp2 = Long.valueOf(String.valueOf(o2) + String.valueOf(o1));
                if (tmp1 > tmp2) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
        };

        Arrays.sort(arr, comp);

        if (arr[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num);
        }

        return sb.toString();
    }
}
