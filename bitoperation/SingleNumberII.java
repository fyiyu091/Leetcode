package bitoperation;

/* Every element appears three times except for one */

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        int[] counter = new int[32];
        for (int n : nums) {
            int mask = 1;
            for (int i = 0; i < 32; i++) {
                if ((mask & n) != 0) {
                    counter[i] += 1;
                }
                mask <<= 1;
            }
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (counter[i] % 3 != 0) {
                res |= 1 << i;
            }
        }

        return res;
    }
}
