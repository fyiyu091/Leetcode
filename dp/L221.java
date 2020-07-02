package dp;

public class L221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[] dp = new int[col];
        int max = 0;

        for (int j = 0; j < col; j++) {
            dp[j] = matrix[0][j] - '0';
            max = Math.max(max, dp[j]);
        }

        /*
           tmp representing [i - 1][j - 1]
           dp[j - 1] is representing [i][j - 1]
           dp[j] is representing [i - 1][j]
         */
        for (int i = 1; i < row; i++) {
            int tmp = dp[0];
            dp[0] = matrix[i][0] - '0';
            max = Math.max(max, dp[0]);
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '1') {
                    int val = Math.min(tmp, Math.min(dp[j - 1], dp[j])) + 1;
                    tmp = dp[j];
                    dp[j] = val;
                    max = Math.max(dp[j], max);
                }
                else {
                    dp[j] = 0;
                }
            }
        }

        return max * max;
    }
}
