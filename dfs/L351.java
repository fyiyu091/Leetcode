package dfs;

/*
   Android unlock patterns
   Can jump a digit if the dest is not visited yet and the jump is visited
   1 2 3
   4 5 6
   7 8 9
   1 -> 9 is possible if 5 is visited
 */
public class L351 {
    public int numberOfPatterns(int m, int n) {
        int[][] jumps = new int[10][10];
        jumps[1][3] = jumps[3][1] = 2;
        jumps[4][6] = jumps[6][4] = 5;
        jumps[7][9] = jumps[9][7] = 8;
        jumps[1][7] = jumps[7][1] = 4;
        jumps[2][8] = jumps[8][2] = 5;
        jumps[3][9] = jumps[9][3] = 6;
        jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;
        boolean[] visited = new boolean[10];
        int count = 0;
        for (int i = m; i <= n; i++) {
            count += dfs(visited, i - 1, 1, jumps) * 4;
            count += dfs(visited, i - 1, 2, jumps) * 4;
            count += dfs(visited, i - 1, 5, jumps);
        }

        return count;
    }

    // With current num and len, what's the
    private int dfs(boolean[] visited, int remaind, int num, int[][] jumps) {
        if (remaind < 0) {
            return 0;
        }
        if (remaind == 0) {
            return 1;
        }

        visited[num] = true;
        int ret = 0;
        for (int next = 1; next <= 9; next++) {
            int jumpNum = jumps[num][next];
            if (!visited[next] && (jumpNum == 0 || visited[jumpNum])) {
                ret += dfs(visited, remaind - 1, next, jumps);
            }
        }
        visited[num] = false;
        return ret;
    }
}
