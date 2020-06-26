package array;

import java.util.Arrays;

public class DedupLeaveK {
    public int[] dedupLeaveK(int[] nums, int k) {
        if (nums == null || nums.length <= k) {
            return nums;
        }

        int slow = k;
        int fast = k;
        while (fast < nums.length) {
            if (nums[slow - k] != nums[fast]) {
                nums[slow++] = nums[fast++];
            }
            else {
                fast++;
            }
        }

        int[] res = new int[slow - 1];
        for (int i = 0; i < slow - 1; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        DedupLeaveK test = new DedupLeaveK();
        int[] nums = {1,1,8,8,8,2,3,3,3,3,4,5,1,1};

        System.out.println(Arrays.toString(test.dedupLeaveK(nums, 3)));
    }
}
