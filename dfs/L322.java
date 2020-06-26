package dfs;

public class L322 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return 0;
        }

        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        int ret = Integer.MAX_VALUE;
        for (int coin : coins) {
            int val = coinChange(coins, amount - coin) + 1;
            if (val > 0 && val < ret) {
                ret = val;
            }
        }

        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}
