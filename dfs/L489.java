package dfs;

import java.util.HashSet;
import java.util.Set;

/* robot room cleaner, the initial position is up */

public class L489 {
    interface Robot {
    public boolean move();

    public void turnLeft();

    public void turnRight();

    public void clean();
    }

    private static final int[][] DIRECTIONS = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // up right down left
    public void cleanRoom(Robot robot) {
        dfs(robot, 0, 0, 0, new HashSet<>());
    }

    private void dfs(Robot robot, int i, int j, int dir, Set<String> visited) {
        robot.clean();

        for (int x = 0; x < 4; x++) {
            int currDir = (dir + x) % 4;
            int ii = i + DIRECTIONS[currDir][0];
            int jj = j + DIRECTIONS[currDir][1];
            if (!visited.add(ii + "+" + jj) && robot.move()) {
                dfs(robot, ii, jj, currDir, visited);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }
    }
}
