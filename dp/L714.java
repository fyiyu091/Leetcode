package dp;

/* Buy and sell as many as you want with a transaction fee */

public class L714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for (int p : prices) {
            buy = Math.max(buy, sell - p);
            sell = Math.max(sell, buy + p - fee);
        }

        return sell;
    }
}
