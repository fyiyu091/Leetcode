package dp;

/* Maximum product subarray */

public class L152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int tmpMax = nums[0];
        int tmpMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int n1 = curr * tmpMax;
            int n2 = curr * tmpMin;

            tmpMax = Math.max(curr, Math.max(n1, n2));
            tmpMin = Math.min(curr, Math.min(n1, n2));
            max = Math.max(max, tmpMax);
        }
        return max;
    }
}
