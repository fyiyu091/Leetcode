package dp;

/* Stock I
*          7 1 5 3 6 4
*  buy min
*  sell 0
*
* */

public class L121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for (int price : prices) {
            buy = Math.max(buy, -price);
            sell = Math.max(sell, price + buy);
        }
        return sell;
    }

    public static void main(String[] args) {
        L121 test = new L121();
        test.maxProfit(new int[] {7,1,5,3,6,4});
    }
}
