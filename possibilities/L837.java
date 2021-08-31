package possibilities;

/*
    w is the maxPts
    For example, maxPts is 3 -> we can choose from [1,2,3]
    What is possibility of reaching 0 -> 1 since we are starting at 0
    What is possibility of reaching 1 -> 1/3 <p[0] * 1/3>
    What is possibility of reaching 2 -> 1/3 (get 2 by one shot) + 1/3 * 1/3 (get 2 by two shots, 1 then 1) -> (1 + 1/3) * 1/3 <(p[0] + p[1]) * 1/3>
    What is possibility of reaching 3 -> 1/3 + 1/3 * 1/3 + 1/3 * 1/3 + 1/3 * 1/3 * 1/3 -> (1 + 1/3 + 1/3 + 1/3 * 1/3) * 1/3
    This becomes (1 + 1/3 + (1 + 1/3) * 1/3) * 1/3
    (p[0] + p[1] + p[2]) * 1/3
    Therefore we have the formula:

    When i <= k (because we would stops at k)
    p[i] = (p[i - 1] + ... p[i - w]) * w / 1
    i - w >= 0 is required, need to i - w - 1 >= 0

    When i > k (We won't add i - 1 because we would have stopped at i - 1 basically after k)
    But we still want to make sure i - w >= 0 is true as for W = 10, we can't draw a 11 card
 */
public class L837 {
    public double new21Game(int n, int k, int maxPts) {
        // Before K we only got 1 shot, so the maximum we can get to is k + maxPts - 1
        // Therefore anything equal or larger than that should have possibility of 1
        if (n >= k + maxPts - 1) {
            return 1.0;
        }

        double[] p = new double[n + 1];
        p[0] = 1;
        double possibility = 1 / (maxPts + 0.0);
        double prev = 0; // prev is not the possibility, it is what's within the parenthesis like (p[i - 1] + ... p[i - w]) * w / 1

        for (int i = 1; i <= k; i++) {
            prev = prev - (i - maxPts - 1 >= 0 ? p[i - maxPts - 1] : 0) + p[i - 1];
            p[i] = prev * possibility;
        }

        double res =p[k];
        for (int i = k + 1; i <= n; i++) {
            prev = prev - (i - maxPts - 1 >= 0 ? p[i - maxPts - 1] : 0);
            p[i] = prev * possibility;
            res += p[i];
        }

        return res;
    }
}
