package greedy;

/* Increasing triplet subsequence
*  DP solution is O(n^2) time complexity and O(n) space complexity
*
* */

public class L334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < min1) {
                min1 = num;
            }
            else if (num < min2) {
                min2 = num;
            }
            else {
                return true;
            }
        }

        return false;
    }
}
