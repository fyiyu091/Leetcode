package amazonoa;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }

        int row = grid.length;
        int col = grid[0].length;

        Queue<Integer> queue = new LinkedList<>();
        addRotten(grid, queue);
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean noRotten = queue.isEmpty();
        int minutes = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                int x = curr / col;
                int y = curr % col;
                for (int[] dir : directions) {
                    int xx = x + dir[0];
                    int yy = y + dir[1];
                    if (xx >= 0 && xx < row && yy >= 0 && yy < col && grid[xx][yy] == 1) {
                        grid[xx][yy] = 2;
                        queue.offer(xx * col + yy);
                    }
                }
            }
            minutes++;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return noRotten ? 0 : minutes;
    }

    private void addRotten(int[][] grid, Queue<Integer> queue) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(i * col + j);
                }
            }
        }
        return;
    }
}
