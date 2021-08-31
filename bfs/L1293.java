package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
    Need to go from top left to bottom right
    Only have 0s and 1s
    At most can eliminate k 1s
    Try to find the minimum steps that need to take

    How to handle the k at most 1s that I can take

 */
public class L1293 {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(0);
        int steps = 0;
        boolean found = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cell = queue.poll();
                int x = cell / n;
                int y = cell % n;
                if (x == m - 1 && y == n - 1) {
                    found = true;
                }
                if (grid[x][y] == 1) {

                }

                for (int[] dir : DIRECTIONS) {
                    int xx = x + dir[0];
                    int yy = y + dir[1];
                    if (xx >= 0 && yy >= 0 && xx < m && yy < n && visited.add(xx * n + yy)) {
                        if (grid[xx][yy] == 1) {
                            k--;
                        }
                        queue.offer(xx * n + yy);
                    }
                }
            }
            steps++;
        }

        if (found) {
            return steps;
        }
        return -1;
    }
}
