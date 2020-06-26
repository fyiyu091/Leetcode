package dp;

/* Coin change */

import java.util.Arrays;

public class L322 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return 0;
        }

        // dp index means coin change to this idx with the minimum needed coins
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        // get 0 amount need 0 coins
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
