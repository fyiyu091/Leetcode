package dp;

/* Paint fence
   No more than two adjacent fence posts have the same color
   Search problem.
   How to branch? At current post, I can paint the same color as the previous one or different color
   diff[i] means the ways to paint current that has different color from previous
   diff[i] = same[i - 1] * (k - 1) + diff[i - 1] * (k - 1)
   same[i] the ways to paint current the same color as the previous one
   same[i] = diff[i - 1] because same[i - 1] means i - 1 has the same paint with i - 2 which won't work for same[i]
 */
public class L276 {
    public int numWays(int n, int k) {
        if (n <= 0) {
            return 0;
        }

        int diff = k, same = 0;
        for (int i = 1; i < n; i++) {
            int tmp = diff;
            diff = (k - 1) * (same + diff);
            same = tmp;
        }

        return diff + same;
    }
}
