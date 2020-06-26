package dfs;

import java.util.HashSet;
import java.util.Set;

public class L490 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) {
            return false;
        }

        Set<Integer> visited = new HashSet<>();
        int row = maze.length;
        int col = maze[0].length;
        return dfs(maze, row, col, start, destination, visited);
    }

    private boolean dfs(int[][] maze, int row, int col, int[] start, int[] destination, Set<Integer> visited) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        if (visited.contains(start[0] * col + start[1])) {
            return false;
        }

        visited.add(start[0] * col + start[1]);
        int l = start[1] - 1, r = start[1] + 1, u = start[0] - 1, d = start[0] + 1;
        while (l >= 0 && maze[start[0]][l] == 0) {
            l--;
        }
        if (dfs(maze, row, col, new int[] {start[0], ++l}, destination, visited)) {
            return true;
        }
        while (r < col && maze[start[0]][r] == 0) {
            r++;
        }
        if (dfs(maze, row, col, new int[] {start[0], --r}, destination, visited)) {
            return true;
        }
        while (u >= 0 && maze[u][start[1]] == 0) {
            u--;
        }
        if (dfs(maze, row, col, new int[] {++u, start[1]}, destination, visited)) {
            return true;
        }
        while (d < row && maze[d][start[1]] == 0) {
            d++;
        }
        if (dfs(maze, row, col, new int[] {--d, start[1]}, destination, visited)) {
            return true;
        }
        return false;
    }
}
