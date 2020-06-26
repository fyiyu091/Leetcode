package bitoperation;

/* Count number of 1s from 0 <= 1 <= num
*  (1001011101) = (605)
*   (100101110) = (302)
*  p(x) = p(x / 2) + (x % 2)
*  (x % 2) is for the lsb
*
* */

public class L338 {
    public int[] countBits(int num) {
        if (num < 0) {
            return new int[0];
        }

        int[] res = new int[num + 1];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }

        return res;
    }
}
