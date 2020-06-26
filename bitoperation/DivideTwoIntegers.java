package bitoperation;

/* Divide two integers without using multiplication, division and mod operation */

public class DivideTwoIntegers {
    public int divide(int divident, int divisor) {
        // corner case
        if (divident == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MIN_VALUE;
        }

        long p = Math.abs((long) divident);
        long q = Math.abs((long) divisor);

        int res = 0;
        while (p >= q) {
            int shift = 0;
            while (p >= (q << shift)) {
                shift++;
            }

            // can handle shift = 1 then res += 1's case
            res += 1 << (shift - 1);
            p -= q << (shift - 1);
        }
        if ((divident > 0 && divisor > 0) || (divident < 0 && divisor < 0)) {
            return res;
        }
        else {
            return -res;
        }
    }

    public static void main(String[] args) {
        DivideTwoIntegers test = new DivideTwoIntegers();
        System.out.println(test.divide(10, 3));
    }
}
