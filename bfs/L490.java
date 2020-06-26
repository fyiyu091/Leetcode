package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/* The maze, ball won't stop until hit a wall */

public class L490 {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int row = maze.length;
        int col = maze[0].length;
        queue.offer(start[0] * col + start[1]);
        visited.add(start[0] * col + start[1]);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int i = curr / col;
            int j = curr % col;
            if (i == destination[0] && j == destination[1]) {
                return true;
            }
            for (int[] dir : DIRECTIONS) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                while (ii >= 0 && ii < row && jj >= 0 && jj < col && maze[ii][jj] == 0) {
                    ii += dir[0];
                    jj += dir[1];
                }
                int prev = (ii - dir[0]) * col + (jj - dir[1]);
                if (visited.add(prev)) {
                    queue.offer(prev);
                }
            }
        }

        return false;
    }
}
