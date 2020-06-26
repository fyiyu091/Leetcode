package greedy;

/* Jump game I */

public class L55 {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        if (nums.length <= 1) {
            return true;
        }

        int maxRange = nums[0];
        for (int i = 0; i <= maxRange; i++) {
            if (maxRange >= nums.length - 1) {
                return true;
            }
            maxRange = Math.max(maxRange, nums[i] + i);
        }
        return false;
    }
}
