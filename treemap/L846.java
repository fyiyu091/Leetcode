package treemap;

import java.util.TreeMap;

/*
   Check if the input can be divided into multiple groups that each group is size W
   and consists of W consecutive cards
 */
public class L846 {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length == 0) {
            return false;
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int n : hand) {
            treeMap.put(n, treeMap.getOrDefault(n, 0) + 1);
        }

        while (!treeMap.isEmpty()) {
            int lowest = treeMap.firstKey();
            for (int i = lowest; i < W + lowest; i++) {
                if (!treeMap.containsKey(i)) {
                    return false;
                }

                treeMap.put(i, treeMap.get(i) - 1);
                if (treeMap.get(i) == 0) {
                    treeMap.remove(i);
                }
            }
        }
        return true;
    }
}
