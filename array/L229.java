package array;

import java.util.ArrayList;
import java.util.List;

/* Major number II
*  Find all elements that appear more than n / 3 times
*  [3,2,3] ans: [3]
*  The possible answer will be size 0, 1 or 2
*  [1,1,1,3,3,2,2,2]
*
* */

public class L229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        Integer num1 = null;
        Integer num2 = null;
        int cnt1 = 0;
        int cnt2 = 0;
        for (int num : nums) {
            if (num1 != null && num == num1) {
                cnt1++;
            }
            else if (num2 != null && num == num2) {
                cnt2++;
            }
            else if (cnt1 == 0) {
                num1 = num;
                cnt1++;
            }
            else if (cnt2 == 0) {
                num2 = num;
                cnt2++;
            }
            else { // num1 and num2 are assigned and we see a different number
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num1 != null && num == num1) {
                cnt1++;
            }
            if (num2 != null && num == num2) {
                cnt2++;
            }
        }

        int len = nums.length / 3;
        if (cnt1 > len) {
            res.add(num1);
        }
        if (cnt2 > len) {
            res.add(num2);
        }

        return res;
    }
}
