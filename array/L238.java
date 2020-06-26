package array;

/* Three case: no zero, one zero, two zeros */

public class L238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] res = new int[nums.length];
        int count = 0;
        int product = 1;
        for (int n : nums) {
            if (n == 0) {
                count++;
                continue;
            }
            product *= n;
        }

        for (int i = 0; i < nums.length; i++) {
            if (count == 1) {
                if (nums[i] == 0) {
                    res[i] = product;
                }
                else {
                    res[i] = 0;
                }
            }
            else if (count == 0) {
                res[i] = product / nums[i];
            }
            else {
                res[i] = 0;
            }
        }
        return res;
    }
}
