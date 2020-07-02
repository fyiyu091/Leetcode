package dp;

import java.util.Arrays;

/*
   Perfect squares
   Perfect square numbers is (1, 4, 9, 16, ...)
   Find the least number of perfect square numbers which sum to n
   n = 12
   12 = 4 + 4 + 4, output will be 3
   n = 25
   25 = 4 + 4 + 4 + 4 + 4 + 4 + 1 -> 7
   25 = 9 + 16 -> 2

   0 1 2    1         1                    1
   0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
   How to branch?
   dp[i] means the least number of perfect square numbers
   dp[i] = min(dp[i - psn] + 1)
 */
public class L279 {
    public int numSquares(int n) {
        if (n < 0) {
            return 0;
        }

        int[] dp = new int[n + 1]; // idx can reach to n
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= Math.sqrt(i); j++) { // j == Math.sqrt(i) means i is a perfect square number
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}
