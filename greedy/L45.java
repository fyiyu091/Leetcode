package greedy;

/* Jump game
*  You can always reach the last index
*  Find the minimum number of jumps that you need
*  How to branch? You can jump [1,num[i]] to the next position
*  Search status, current position
*  Need two variable, one we know that the current max position
*  The other will be the nextMaxPos, we keep updating that while iterating
* */

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
