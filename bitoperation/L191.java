package bitoperation;

/* Number of 1 bits */

public class L191 {
    public int hammingWeight(int n) {
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) { // Need to have 32 times comparison
            if ((n & mask) != 0) {
                res++;
            }
            mask <<= 1;
        }

        return res;
    }
}
