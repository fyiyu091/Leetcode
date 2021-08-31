package slidingwindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Calculate the angle of each point to the location
    Sort them and sliding window to find the maximum points that can be covered
 */
public class L1610 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int count = 0;
        for (List<Integer> p : points) {
            int dx = p.get(0) - location.get(0);
            int dy = p.get(1) - location.get(1);
            if (dx == 0 && dy == 0) { // edge case of same point
                count++;
                continue;
            }
            angles.add(Math.atan2(dy, dx) * (180 / Math.PI));
        }
        Collections.sort(angles);
        List<Double> tmp = new ArrayList<>(angles);
        // -135 and 135 can be covered by 90 degrees, the way to handle is to have -135 135 125 495 instead of just -135
        for (double d : angles) tmp.add(d + 360); // concatenate to handle edge case
        int res = count;
        int i = 0, j = 0;
        while (j < tmp.size()) {
            while (tmp.get(j) - tmp.get(i) > angle) {
                i++;
            }
            res = Math.max(res, count + j - i + 1);
            j++;
        }
        return res;
    }
}
