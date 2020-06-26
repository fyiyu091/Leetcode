package binaryreduction;

public class L50 {
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            return (double) 1 / (myPow(x, n - 1) * x);
        }

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n < 0) {
            return (double) 1 / myPow(x, -n);
        }

        double tmp = myPow(x, n / 2);
        return n % 2 == 0 ? tmp * tmp : tmp * tmp * x;
    }
}
