package slidingwindow;

/*
    Find the maximum scores
    How to branch, pick leftmost or rightmost two options
    Search status

    X means the one that being picked
    Basically, trying to find the minimum ___ window
    XXX_____
    XX_____X
    X_____XX
    _____XXX
 */
public class L1423 {
    public int maxScore(int[] cardPoints, int k) {
        if (cardPoints == null || cardPoints.length == 0) {
            return 0;
        }

        int sum = 0;
        int len = cardPoints.length;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        int max = sum;
        for (int i = 1; i <= k; i++) {
            sum = sum + cardPoints[len - i] - cardPoints[k - i];
            max = Math.max(max, sum);
        }

        return max;
    }

}
