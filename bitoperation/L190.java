package bitoperation;

/* Reverse bits */

public class L190 {
    public int reverseBits(int n) {
        // Using the swap idea, so that we only needs 15 times swap
        for (int i = 0; i < 15; i++) {
            int left = (n >> 31 - i) & 1;
            int right = (n >> i) & 1;
            if (left != right) {
                n ^= 1 << 31 - i;
                n ^= 1 << i;
            }
        }

        return n;
    }
}
