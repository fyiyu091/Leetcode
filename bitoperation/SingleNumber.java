package bitoperation;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }

        return xor;
    }
}
