package dp;

/* Robot move from top left to bottom right with obstacles */

public class L63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[] dp = new int[col];


        for (int j = 0; j < col; j++) {
            if (obstacleGrid[0][j] != 1) {
                dp[j] = 1;
            }
            else {
                break;
            }
        }

        for (int i = 1; i < row; i++) {
            // last row is accessible and the position is open
            dp[0] = (dp[0] == 1 && obstacleGrid[i][0] == 0) ? 1 : 0;
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                }
                else {
                    dp[j] = dp[j - 1] + dp[j];
                }

            }
        }

        return dp[col - 1];
    }
}
