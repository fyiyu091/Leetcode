package dp;

/*
    Paint house
    Only have three colors for each house, no two adjacent houses have the same color
    How to branch? current house can chose one out of two colors that are not to the adjacent one
    dp[i][j] means house i paint with color j, the minimum cost
 */
public class L256 {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int houses = costs.length;
        int colors = costs[0].length;
        int[][] dp = new int[houses][colors];

        for (int j = 0; j < colors; j++) {
            dp[houses - 1][j] = costs[houses - 1][j];
        }

        for (int i = houses - 2; i >= 0; i--) {
            for (int j = 0; j < colors; j++) {
                for (int k = 0; k < colors; k++) {
                    if (j == k) {
                        continue;
                    }
                    if (dp[i][j] == 0) {
                        dp[i][j] = costs[i][j] + dp[i + 1][k];
                    }
                    else {
                        dp[i][j] = Math.min(dp[i][j], costs[i][j] + dp[i + 1][k]);
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < colors; j++) {
            res = Math.min(res, dp[0][j]);
        }

        return res;
    }
}
