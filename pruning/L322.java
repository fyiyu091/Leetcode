package pruning;

import java.util.Arrays;

public class L322 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        int[] mem = new int[amount + 1];
        Arrays.fill(mem, -2);
        return dfs(coins, amount, mem);
    }

    private int dfs(int[] coins, int amount, int[] mem) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        if (mem[amount] != -2) {
            return mem[amount];
        }

        int retVal = Integer.MAX_VALUE;
        for (int coin : coins) {
            int val = dfs(coins, amount - coin, mem) + 1;
            if (val > 0 && val < retVal) {
                retVal = val;
            }
        }

        if (retVal != Integer.MAX_VALUE) {
            mem[amount] = retVal;
        }
        else {
            mem[amount] = -1;
        }
        return mem[amount];
    }
}
