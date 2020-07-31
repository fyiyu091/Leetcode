package dp;

/* Stock II
*
*           7   1  5  3  6  4
 *  buy min -7  -1 -1 1  1  3
 *  sell 0  0   0  4  4  7  7
 *
 *           2   3   4   5
 *  buy min -2  -2  -2  -2
 *  sell 0   0   1   2   3
* */

public class L122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for (int p : prices) {
            buy = Math.max(buy, sell - p);
            sell = Math.max(sell, buy + p);
        }

        return sell;
    }
}
