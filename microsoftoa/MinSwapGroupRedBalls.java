package microsoftoa;

import java.util.ArrayList;
import java.util.List;

public class MinSwapGroupRedBalls {
    public int minSwap(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Value is the index for each red ball
        List<Integer> redIndices = getRedIndices(s);
        int mid = redIndices.size() / 2;
        int minSwap = 0;
        for (int i = 0; i < redIndices.size(); i++) {
            // The swap needed for each R is the distance to the mid one and then minus the Rs between
            minSwap = Math.abs(redIndices.get(mid) - redIndices.get(i)) - Math.abs(mid - i);
        }
        return minSwap;
    }

    private List<Integer> getRedIndices(String s) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                res.add(i);
            }
        }
        return res;
    }
}
