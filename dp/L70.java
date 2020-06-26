package dp;

/* Climbing stairs */

public class L70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int first = 1;
        int second = 2;
        for (int i = 2; i < n; i++) {
            int tmp = first + second;
            first = second;
            second = tmp;
        }

        return second;
    }
}
