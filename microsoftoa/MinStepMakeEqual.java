package microsoftoa;

import java.util.Arrays;

public class MinStepMakeEqual {
    public int minSteps(int[] piles) {
        if (piles == null || piles.length < 1) {
            return 0;
        }

        Arrays.sort(piles);

        int res = 0;
        int distinctNum = 0;
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] != piles[i - 1]) {
                distinctNum++;
            }
            res += distinctNum;
        }

        return res;
    }
}
