package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class L286 {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) {
            return;
        }

        int row = rooms.length;
        int col = rooms[0].length;
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(i * col + j);
                }
            }
        }

        bfs(rooms, queue);
        return;
    }

    private void bfs(int[][] rooms, Queue<Integer> queue) {
        int row = rooms.length;
        int col = rooms[0].length;
        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                int x = curr / col;
                int y = curr % col;
                for (int[] dir : DIRECTIONS) {
                    int xx = x + dir[0];
                    int yy = y + dir[1];
                    if (xx >= 0 && xx < row && yy >= 0 && yy < col && rooms[xx][yy] == Integer.MAX_VALUE) {
                        rooms[xx][yy] = dist;
                        queue.offer(xx * col + yy);
                    }
                }
            }
            dist++;
        }
    }
}
