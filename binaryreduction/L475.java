package binaryreduction;

/* Heaters */

import java.util.Arrays;

// For every house try to find the distance to the closest heater
// Overall longest distance will be the warm radius
public class L475 {
    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length == 0) {
            return 0;
        }
        int res = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int dist = shortestDist(house, heaters);
            res = Math.max(res, dist);
        }

        return res;
    }

    private int shortestDist(int house, int[] heaters) {
        int left = 0;
        int right = heaters.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (heaters[mid] == house) {
                return 0;
            }
            else if (heaters[mid] < house) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return Math.min(Math.abs(heaters[left] - house), Math.abs(heaters[right] - house));
    }
}
