package dp;

/* Stock III, at most buy and sell two */

public class L123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;
        for (int p : prices) {
            sell2 = Math.max(sell2, p + buy2);
            buy2 = Math.max(buy2, -p + sell1);

            sell1 = Math.max(sell1, p + buy1);
            buy1 = Math.max(buy1, -p);
        }

        return Math.max(sell1, sell2);
    }
}
