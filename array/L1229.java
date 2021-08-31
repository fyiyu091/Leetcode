package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1229 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);

        int p1 = 0;
        int p2 = 0;
        List<Integer> res = new ArrayList<>();

        while (p1 < slots1.length && p2 < slots2.length) {
            int diff = Math.min(slots1[p1][1], slots2[p2][1]) - Math.max(slots1[p1][0], slots2[p2][0]);
            if (diff >= duration) {
                res.add(Math.max(slots1[p1][0], slots2[p2][0]));
                res.add(Math.max(slots1[p1][0], slots2[p2][0]) + duration);
                return res;
            }

            if (slots1[p1][1] < slots2[p2][1]) {
                p1++;
            }
            else {
                p2++;
            }
        }

        return res;
    }
}
