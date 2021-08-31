package array;

/*
    Partition array into disjoint intervals
    1. Keep update the nextMax for future usage
    2. If the current value is lower than the currMax, need to extend the partition and update with the nextMax
 */
public class L915 {
    public int partitionDisjoint(int[] nums) {
        int nextMax = nums[0];
        int currMax = nums[0];
        int res = 0;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // Keep updating for the future usage
            nextMax = Math.max(nextMax, num);
            if (num < currMax) {
                res = i;
                currMax = Math.max(currMax, nextMax);
            }
        }

        return res + 1;
    }
}
