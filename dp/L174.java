package dp;

/*
   Dungeon game
   From top left room to bottom right
   Health can't be <= 0 before reach bottom right
   Each cell has a value
   int[i][j], meaning from top left room to this location, the minimum initial health

   Why we can't be from top left to bottom right, because it will depends on the bottom right value
   dp[i][j] = Math.max(1, Math.min(dp[i - 1][j], dp[i][j - 1]) - matrix[i][j])

   -2 -3  3
   -5 -10 1
   10 30 -5

   7  5  2
   6  11 5
   1  1  6

 */
public class L174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon.length == 0) {
            return 0;
        }

        int row = dungeon.length;
        int col = dungeon[0].length;

        int[][] dp = new int[row][col];
        dp[row - 1][col - 1] = Math.max(1, 1 - dungeon[row - 1][col - 1]); // first, must be positive, then if dungeon is negative have to keep it at least 1

        for (int i = row - 2; i >= 0; i--) {
            dp[i][col - 1] = Math.max(1, dp[i + 1][col - 1] - dungeon[i][col - 1]);
        }
        for (int j = col - 2; j >= 0; j--) {
            dp[row - 1][j] = Math.max(1, dp[row - 1][j + 1] - dungeon[row - 1][j]);
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }

        return dp[0][0];
    }
}
