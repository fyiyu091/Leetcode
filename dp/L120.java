package dp;

/* Triangle, find the minimum path sum from top to bottom */

import java.util.List;

public class L120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }

        int len = triangle.size();
        // what does dp means, at idx level to the bottom, the minimum path sum
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = triangle.get(len - 1).get(i);
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}
