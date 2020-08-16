package greedy;

import java.util.HashMap;
import java.util.Map;

/*
   Check whether array can be split into 1 or more subsequences such that each
   subsequence consists of consecutive integers and has length at least 3

   1 1 2 2 3 3 4
   1 2 3 4
   1 2 3

   Basically, greedy is on whether the number should joining a subsequence, if it can join, it should
 */
public class L659 {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> tailMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            // Check if countMap still have counts
            if (countMap.containsKey(num)) {
                if (tailMap.containsKey(num)) {
                    tailMap.put(num, tailMap.get(num) - 1);
                    if (tailMap.get(num) == 0) {
                        tailMap.remove(num);
                    }
                    countMap.put(num, countMap.get(num) - 1);
                    if (countMap.get(num) == 0) {
                        countMap.remove(num);
                    }
                    tailMap.put(num + 1, tailMap.getOrDefault(num + 1, 0) + 1);
                }
                // No tailMap wants it, should create its own subsequence
                else {
                    for (int i = 0; i < 3; i++) {
                        if (!countMap.containsKey(num + i)) {
                            return false;
                        }
                        countMap.put(num + i, countMap.get(num + i) - 1);
                        if (countMap.get(num + i) == 0) {
                            countMap.remove(num + i);
                        }
                    }
                    tailMap.put(num + 3, tailMap.getOrDefault(num + 3, 0) + 1);
                }
            }
            else {
                continue;
            }
        }
        return true;
    }
}
