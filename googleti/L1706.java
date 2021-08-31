package googleti;

public class L1706 {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];

        for (int k = 0; k < n; k++) {
            int move = 0;
            // Starting at row 0
            int i = 0;
            int j = k;
            while (i < m) {
                if (grid[i][j] == 1 && j + 1 < n && grid[i][j + 1] == 1) {
                    move++;
                    i++;
                    j++;
                }
                else if (grid[i][j] == -1 && j - 1 >= 0 && grid[i][j - 1] == -1) {
                    move--;
                    i++;
                    j--;
                }
                else {
                    res[k] = -1;
                    break;
                }
            }
            if (i == m) {
                res[k] = k + move;
            }
        }

        return res;
    }
}
