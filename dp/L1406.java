package dp;

public class L1406 {
    public String stoneGameIII(int[] stoneValue) {
        int len = stoneValue.length;
        int[] dp = new int[len + 1];

        for (int i = len - 1; i >= 0; i--) {
            int val = stoneValue[i] - dp[i + 1];
            val = Math.max(val, i + 1 < len ? stoneValue[i] + stoneValue[i + 1] - dp[i + 2] : val);
            val = Math.max(val, i + 2 < len ? stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[i + 3] : val);
            dp[i] = val;
        }

        int res = dp[0];
        if (res > 0) {
            return "Alice";
        }
        if (res < 0) {
            return "Bob";
        }
        return "Tie";
    }
}
