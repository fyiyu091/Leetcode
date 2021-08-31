package dfs;

import java.util.HashMap;
import java.util.Map;

/*
    Optimal account balancing

    1. Convert the transactions the the int[], index means Person # and value means how much it owns,
       10 means this person owns someone else 10 dollars, -10 means this person need to collect 10 dollars
    2. Getting the above array
       [0,1,10], [2,0,5]

       [-5, 10, -5]

    The end goal is to have all of the person have 0 balance

    How to branch? Standing at this person, find the person who can even it out
    Search state? index i assuming [0, i - 1] were all went to 0
    Return value? the minimum transfer needed
 */
public class L465 {
    public int minTransfers(int[][] transactions) {
        int[] debt = getPersonalDebts(transactions);

        return getMiniTransfer(debt, 0);
    }

    private int getMiniTransfer(int[] debt, int idx) {
        while (idx < debt.length && debt[idx] == 0) {
            idx++;
        }

        if (idx == debt.length) {
            return 0;
        }

        int res = Integer.MAX_VALUE;

        // if we get here, i won't be the last index
        // we sure would gets into the if loop so that the res won't be Integer.MAX_VALUE
        for (int i = idx + 1; i < debt.length; i++) {
            if (debt[i] * debt[idx] < 0) {
                debt[i] += debt[idx];
                res = Math.min(res, getMiniTransfer(debt, idx + 1) + 1);
                debt[i] -= debt[idx];
            }
        }

        return res;
    }

    private int[] getPersonalDebts(int[][] transcations) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] transcation : transcations) {
            int from = transcation[0];
            int to = transcation[1];
            int amount = transcation[2];
            map.put(from, map.getOrDefault(from, 0) - amount);
            map.put(to, map.getOrDefault(to, 0) + amount);
        }

        int[] res = new int[map.size()];
        int i = 0;
        // Here we don't care if the index of the res array match the key of the hashmap
        // Since eventually our goal is to even everybody out
        for (int amount : map.values()) {
            res[i++] = amount;
        }

        return res;
    }
}
