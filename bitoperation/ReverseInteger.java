package bitoperation;

/* 235 reverse to 532 */

public class ReverseInteger {
    public int reverseInteger(int n) {
        int res = 0;
        while (n > 0) {
            if (n > Integer.MAX_VALUE) {
                throw new IllegalArgumentException();
            }
            res = res * 10 + n % 10;  // all different based 2, 5, 7, can just change it to other numbers
            n /= 10;
        }

        return res;
    }
}
