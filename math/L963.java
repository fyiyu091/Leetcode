package math;

import java.util.HashSet;
import java.util.Set;

/*
    Find the minimum area rectangle II
    determine the minimum area of any rectangle formed from these points

    Use two key property of rectangle
    1. For three points, Pythagorean theorem
    2. x1 + x3 = x2 + x4 and y1 + y3 = y2 + y4
 */
public class L963 {
    public double minAreaFreeRect(int[][] points) {
        Set<String> pointSet = new HashSet<>();
        for (int[] point : points) {
            pointSet.add(point[0] + "," + point[1]);
        }
        double res = Double.MAX_VALUE;

        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] && p1[1] == p2[1]) {
                    continue;
                }

                for (int[] p3 : points) {
                    if ((p3[0] == p1[0] && p3[1] == p1[1]) || (p3[0] == p2[0] && p3[1] == p2[1])) {
                        continue;
                    }

                    // Need to square anyway, so don't square in the dist
                    if (dist(p1, p3) + dist(p2, p3) != dist(p1, p2)) {
                        continue;
                    }

                    int x = p1[0] + p2[0] - p3[0];
                    int y = p1[1] + p2[1] - p3[1];
                    if (!pointSet.contains(x + "," + y)) {
                        continue;
                    }

                    // When calculating the actual distance, still needs to square up
                    double area = Math.sqrt(dist(p1, p3)) * Math.sqrt(dist(p2, p3));
                    res = Math.min(res, area);
                }
            }
        }

        return res == Double.MAX_VALUE ? 0 : res;
    }

    private double dist(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
