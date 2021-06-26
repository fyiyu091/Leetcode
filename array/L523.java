package array;

/* continuous subarray sum, array values are non-negative
*  If the prefix sum have the same reminder then the difference
*  would be the multiply of k
*  a = n1 * k + r1
*  b = n2 * k + r2
*
*  if r1 == r2 then b - a = (n2 - n1) * k, n2 - n1 can be 0
* */

import java.util.HashMap;
import java.util.Map;

public class L523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        // key is the prefix sum % k, value is the first idx
        Map<Integer, Integer> map = new HashMap<>();
        // [3, 3] if k is 6, then we would have 1 - (-1) == 2
        // which should be the a valid answer
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // if k == 0, then we are looking for the exact same sum
            int reminder = k == 0 ? sum : sum % k;
            if (map.containsKey(reminder)) {
                if (i - map.get(reminder) >= 2) {
                    return true;
                }
            }
            else {
                map.put(reminder, i);
            }
        }

        return false;
    }
}
