package bitoperation;

/* Two elements appear only once and all other elements appear twice */

public class L260 {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int num1 = 0, num2 = 0;
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }

        int bit = 0;
        while (bit < 32) {
            if ((xor & (1 << bit)) != 0) {
                break;
            }
            bit++;
        }

        for (int n : nums) {
            if ((n & (1 << bit)) == 0) {
                num1 ^= n;
            }
            else {
                num2 ^= n;
            }
        }

        return new int[] {num1, num2};
    }
}
