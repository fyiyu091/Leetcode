package pruning;

import java.util.HashMap;
import java.util.Map;

public class LC1406 {
    public String stoneGameIII(int[] stoneValue) {
        Map<Integer, Integer> mem = new HashMap<>();
        int res = dfs(stoneValue, 0, mem);
        if (res > 0) {
            return "Alice";
        }
        if (res < 0) {
            return "Bob";
        }
        return "Tie";
    }

    /*
        Search state: stating at current idx
        Return value: what's the maximum stones I can get
     */
    private int dfs(int[] stoneValue, int idx, Map<Integer, Integer> mem) {
        if (mem.containsKey(idx)) {
            return mem.get(idx);
        }
        if (idx >= stoneValue.length) {
            return 0;
        }

        int sum = stoneValue[idx] - dfs(stoneValue, idx + 1, mem);
        if (idx + 1 < stoneValue.length) {
            sum = Math.max(sum, stoneValue[idx] + stoneValue[idx + 1] - dfs(stoneValue, idx + 2, mem));
        }
        if (idx + 2 < stoneValue.length) {
            sum = Math.max(sum, stoneValue[idx] + stoneValue[idx + 1] + stoneValue[idx + 2] - dfs(stoneValue, idx + 3, mem));
        }

        mem.put(idx, sum);
        return sum;
    }
}
