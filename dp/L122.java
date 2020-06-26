package dp;

/* Stock II */

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

    public static void main(String[] args) {
        L122 test = new L122();
        test.maxProfit(new int[] {7,1,5,3,6,4});
    }
}
