package bfs;

import java.util.*;

/* Return all possible combinations of k numbers out of 1 ... n
*  1,2,3,4
*  if k = 2
*  12,13,14,23,24,34
*  It is combination -> 34 and 43 are considered the same one
* */

public class L77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        // Queue stores List<Integer> for poll and offer
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>());

        // All the levels
        for (int i = 0; i < k; i++) {
            int size = queue.size();
            // To separate curr level from the adding elements
            while (size-- > 0) {
                List<Integer> curr = queue.poll();
                int num = curr.size() == 0 ? 0 : curr.get(curr.size() - 1);
                // Adding one element
                for (int j = num + 1; j <= n; j++) {
                    List<Integer> next = new ArrayList<>();
                    next.addAll(curr);
                    next.add(j);
                    queue.offer(next);
                }
            }
        }

        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }

        return res;
    }
}
