package array;

/* 3Sum, find all unique triplets and the array contains duplicate */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);
        int i = 0;

        while (i < nums.length - 2) {
            int left = i + 1;
            int right = nums.length - 1;
            int target = 0 - nums[i];
            // Exhaust all the combinations with i as the index
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    right--;
                }
                else if (nums[left] + nums[right] > target) {
                    right--;
                }
                else {
                    left++;
                }
            }
            // To avoid the same i
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
            i++;
        }

        return res;
    }
}
