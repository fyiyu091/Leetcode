package greedy;

/* Jump game */

public class L45 {
    public int jump(int[] nums) {
        if (nums == null) throw new IllegalArgumentException();
        if (nums.length <= 1) return 0;

        int steps = 1;
        int maxPos = nums[0];
        int nextMaxPos = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > maxPos) {
                steps++;
                maxPos = nextMaxPos;
            }
            nextMaxPos = Math.max(nextMaxPos, nums[i] + i);
        }

        return steps;
    }
}
