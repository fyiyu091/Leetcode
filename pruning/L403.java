package pruning;

/* Frog jump, can only jump k - 1, k or k + 1 */

import java.util.HashMap;
import java.util.Map;

public class L403 {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length <= 1) return true;

        if (stones[1] != 1) return false;
        Map<Integer, Boolean>[] mem = new HashMap[stones.length];
        for (int i = 0; i < mem.length; i++) {
            mem[i] = new HashMap<>();
        }

        return dfs(stones, 0, 0, mem);
    }

    private boolean dfs(int[] stones, int index, int k, Map<Integer, Boolean>[] mem) {
        if (index == stones.length - 1) {
            return true;
        }

        if (mem[index].get(k) != null) {
            return mem[index].get(k);
        }

        for (int i = index + 1; i < stones.length; i++) {
            int dist = stones[i] - stones[index];
            if (dist < k - 1) {
                continue;
            }
            if (dist > k + 1) {
                break;
            }
            else {
                if (dfs(stones, i, dist, mem)) {
                    mem[i].put(dist, true);
                    return true;
                }
            }
        }
        mem[index].put(k, false);
        return false;
    }
}
