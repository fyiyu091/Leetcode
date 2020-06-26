package bitoperation;

/* Power of two
*  Determine is the number is power of two
* */

public class L231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int mask = 1;
        int numOfOne = 0;
        for (int i = 0; i < 32; i++) {
            if ((mask & n) != 0) {
                numOfOne++;
            }
            mask <<= 1;
        }

        return numOfOne == 1;
    }
}
