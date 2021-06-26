package bitoperation;

/* Reverse bits */

public class L190 {
    public int reverseBits(int n) {
        // Using the swap idea, so that we only needs 15 times swap
        for (int i = 0; i < 15; i++) {
            int left = (n >> 31 - i) & 1;
            int right = (n >> i) & 1;
            // What does this mean?
            // If left == right, no need to swap man
            // 1 xor 1 is 0, 0 xor 1 is 1 so it can do the swap
            if (left != right) {
                n ^= 1 << 31 - i;
                n ^= 1 << i;
            }
        }

        return n;
    }
}
