package array;

/* Best time to buy and sell stock I, just buy and sell one time */

public class L121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int buy = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy) {
                profit = Math.max(profit, prices[i] - buy);
            }
            else {
                buy = prices[i];
            }
        }

        return profit;
    }
}
