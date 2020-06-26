package array;

/* Find all duplicates in the array */

import java.util.ArrayList;
import java.util.List;

public class L442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            }
            else {
                res.add(num);
            }
        }
        return res;
    }

}
