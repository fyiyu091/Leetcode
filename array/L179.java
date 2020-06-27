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
                String str1 = String.valueOf(o1) + String.valueOf(o2);
                String str2 = String.valueOf(o2) + String.valueOf(o1);
                return str2.compareTo(str1); // if it returns -1 means str1 is larger means o1 should be in front
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
