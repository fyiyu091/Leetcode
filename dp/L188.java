package dp;

/* Stock IV, at most k transactions */

public class L188 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int len = prices.length;
        int[][] buy = new int[k + 1][len];
        int[][] sell = new int[k + 1][len];

        for (int kk = 1; kk <= k; kk++) {
            buy[kk][0] = -prices[0];
            for (int i = 1; i < len; i++) {

                sell[kk][i] = Math.max(sell[kk][i - 1], buy[kk][i - 1] + prices[i]);
                buy[kk][i] = Math.max(buy[kk][i - 1], sell[kk - 1][i - 1] - prices[i]);
            }
        }

        return sell[k][len - 1];
    }
}
