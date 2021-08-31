package pruning;

/* Can I win
*  Maximum available number is smaller than 20
*  We could use a int to representing each number's chosen situation
*  desiredTotal can be calculated from the maximum available number
* */

import java.util.HashMap;
import java.util.Map;

public class L464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return true;
        }
        if (maxChoosableInteger <= 0) {
            return false;
        }

        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if(sum < desiredTotal) {
            return false;
        }

        // maxChoosableInteger will not be larger than 20, use a int representing state
        // use a map to do mem from state to boolean
        Map<Integer, Boolean> mem = new HashMap<>();
        return dfs(0, maxChoosableInteger, desiredTotal, mem);
    }

    // state is indicating which one is picked instead of using boolean array
    private boolean dfs(int state, int maxChoosableInteger, int desiredTotal, Map<Integer, Boolean> mem) {
        if (mem.get(state) != null) {
            return mem.get(state);
        }
        // Fuck, the other player is already getting desiredTotal points, I am losing man
        if (desiredTotal <= 0) {
            mem.put(state, false);
            return false;
        }

        for (int i = 1; i <= maxChoosableInteger; i++) {
            if ((state & (1 << i)) == 0) {
                boolean res = dfs(state | (1 << i), maxChoosableInteger, desiredTotal - i, mem);
                if (!res) {
                    mem.put(state, true);
                    return true;
                }
            }
        }

        mem.put(state, false);
        return false;
    }
}
