package dp;

import java.util.Arrays;

/*
   Freedom trail
   Need to spell key with the minimum steps based on ring
   Move is counted as one step, press after aligned is also counted as one step
   How to branch? The previous i must be matched, what was the previous position of matched i is our branching here
   Search status: dp[i][j] i means the index of key or trying to rotate index i key element
                           j means which letter the 12 o'clock is pointing at
   dp[i][j] values means the minimum step
   the final answer isn't a specific value, however it is min out of all the different position that matches the last index


   ring = "godding", key = "gd"
           0123321

 */
public class L514 {
    public int findRotateSteps(String ring, String key) {
        if (ring == null || key == null) {
            throw new IllegalArgumentException();
        }

        int row = key.length();
        int col = ring.length();

        int[][] dp = new int[row][col];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // For the first letter in key, what's the cost when 12 is pointing at different letter in ring
        for (int j = 0; j < col; j++) {
            if (key.charAt(0) == ring.charAt(j)) {
                dp[0][j] = getDist(0, j, ring) + 1; // Adding one for confirm button cost
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (key.charAt(i) == ring.charAt(j)) {
                    for (int k = 0; k < col; k++) {
                        if (dp[i - 1][k] != Integer.MAX_VALUE) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + getDist(j, k, ring) + 1);
                        }
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < col; j++) {
            res = Math.min(res, dp[row - 1][j]);
        }
        return res;
    }

    private int getDist(int i, int j, String ring) {
        return Math.min(Math.abs(j - i), ring.length() - Math.abs(j - i));
    }
}
