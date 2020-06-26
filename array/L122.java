package array;

/* Best time to buy and sell stock II, can buy and sell multiple times */

public class L122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int profit = 0;
        int peek = prices[0];
        int valley = prices[0];
        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peek = prices[i];
            profit += peek - valley;
        }

        return profit;
    }
}
