package math;

import java.util.HashSet;
import java.util.Set;

/*
    To validate if these four points form a square
    we would need to verify that if we only have two distances between all the points
    We only have two distance and longer is 2 * shorter
 */
public class L593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> distSet = new HashSet<>();
        distSet.add(getDistance(p1, p2));
        distSet.add(getDistance(p1, p3));
        distSet.add(getDistance(p1, p4));
        distSet.add(getDistance(p2, p3));
        distSet.add(getDistance(p2, p4));
        distSet.add(getDistance(p3, p4));

        if (distSet.size() != 2) {
            return false;
        }

        int max = 0;
        for (int dist : distSet) {
            max = Math.max(max, dist);
        }

        for (int dist : distSet) {
            if (dist != max && dist * 2 != max) {
                return false;
            }
        }

        return true;
    }

    private int getDistance(int[] p1, int[] p2) {
        int x = p2[0] - p1[0];
        int y = p2[1] - p1[1];
        return y * y + x * x;
    }
}
