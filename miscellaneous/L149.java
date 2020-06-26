package miscellaneous;

/* Max points on a line */

import java.util.HashMap;
import java.util.Map;

public class L149 {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;

        int res = 0;

        for (int i = 0; i < points.length; i++) {
            int pointMax = 0;
            int same = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) { // Starting from index i and looking forward
                int deltaX = points[j][0] - points[i][0];
                int deltaY = points[j][1] - points[i][1];
                if (deltaX == 0 && deltaY == 0) {
                    same++;
                }
                else { // Three different case, same horizontal, same vertical, the other slope
                    String key;
                    if (deltaX == 0) {
                        key = "inf";
                    }
                    else if (deltaY == 0) {
                        key = "0";
                    }
                    else {
                        int gcd = getGCD(deltaX, deltaY);
                        String x = String.valueOf(deltaX / gcd);
                        String y = String.valueOf(deltaY / gcd);
                        key = x + "#" + y;
                    }
                    map.put(key, map.getOrDefault(key, 0) + 1);
                    // For the specific starting point, find its max pointMax
                    pointMax = Math.max(map.get(key), pointMax);
                }
            }
            res = Math.max(res, pointMax + same + 1);
        }
        return res;
    }

    /*
       x = 15, y = 25
       x = 25, y = 15
       x = 15, y = 10
       x = 10, y = 5
       y = 5, x = 0 -> gcd is 5
     */
    private int getGCD(int x, int y) {
        if (y == 0) return x;
        return getGCD(y, x % y);
    }
}
