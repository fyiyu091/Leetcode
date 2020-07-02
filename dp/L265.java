package dp;

/*
   Paint house II
   [[1,5,3],[2,9,4]]
   First layer index is representing house
   Second layer index is representing color
   Value is representing the cost of paint that color on that house
   Find the minimum cost to paint all houses with no adjacent houses have the same color
   dp[i][j] means at house i picking color j's minimum cost to paint all houses follow house i
   dp[i][j] = min(dp[i - 1][ not j] + costs[i][j])

 */
public class L265 {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0] == null || costs[0].length == 0) {
            return 0;
        }

        int row = costs.length;
        int col = costs[0].length;
        int[] dp = costs[row - 1];

        for (int i = row - 2; i >= 0; i--) {
            int[] currentRow = new int[col];
            for (int j = 0; j < col; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < col; k++) {
                    if (k == j) {
                        continue;
                    }
                    else {
                        min = Math.min(min, costs[i][j] + dp[k]);
                    }
                }
                currentRow[j] = min;
            }
            // Have to finish all the values then change the entire row
            // Because we don't want to change dp row's value while calculating all the values
            dp = currentRow;
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < col; j++) {
            res = Math.min(res, dp[j]);
        }

        return res;
    }
}
