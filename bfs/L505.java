package bfs;

/* The maze II, the edge is weighted, not just 1 */

import java.util.LinkedList;
import java.util.Queue;

public class L505 {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) {
            return 0;
        }

        // keep a 2D matrix, representing the shortest distance to the start position
        int row = maze.length;
        int col = maze[0].length;
        int[][] dist = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[start[0]][start[1]] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];
            for (int[] dir : DIRECTIONS) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                int count = 1; // Already taking a step
                while (ii >= 0 && ii < row && jj >= 0 && jj < col && maze[ii][jj] == 0) {
                    ii += dir[0];
                    jj += dir[1];
                    count++; // Already reaching the unavailable area
                }

                if (dist[i][j] + count - 1 < dist[ii - dir[0]][jj - dir[1]]) {
                    dist[ii - dir[0]][jj - dir[1]] = dist[i][j] + count - 1;
                    queue.offer(new int[] {ii - dir[0], jj - dir[1]});
                }
            }
        }

        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? - 1 : dist[destination[0]][destination[1]];
    }
}
