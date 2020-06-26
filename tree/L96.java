package tree;

/* Best solution will be using dp */

public class L96 {
    public int numTrees(int n) {
        if (n < 1) {
            return 0;
        }

        return helper(n);
    }

    private int helper(int n) {
        if (n <= 1) {
            return 1;
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            int fromLeft = helper(i - 1);
            int fromRight = helper(n - i);
            res += fromLeft * fromRight;
        }

        return res;
    }
}
