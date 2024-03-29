package dp;

/* How many unique BST that store values 1 ... n
*  dp[i] means with i numbers how many unique BST
*  dp[0] is 1 because null is a BST
*  dp[1] is 1 because 1 node only has one BST
*
* */

public class L96 {
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) { // both end point can be 0
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
