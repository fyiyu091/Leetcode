package amazonoa;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/* 2D board BFS, 'X' is treasure island, 'O' is safe, 'D' is unsafe
   Always starting from top left
 */
public class TreasureIsland {
    public int treasureIsland(char[][] water) {
        if (water == null || water.length == 0 || water[0] == null || water[0].length == 0) {
            return 0;
        }

        int row = water.length;
        int col = water[0].length;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                int x = curr / col;
                int y = curr % col;
                for (int[] dir : directions) {
                    int xx = x + dir[0];
                    int yy = y + dir[1];
                    if (water[xx][yy] == 'X') {
                        return steps;
                    }
                    if (xx >= 0 && xx < row && yy >= 0 && yy < col && water[xx][yy] == 'O' && !visited.contains(xx * col + yy)) {
                        queue.offer(xx * col + yy);
                        visited.add(xx * col + yy);
                    }
                }
            }
            steps++;
        }
        return 0;
    }

}
