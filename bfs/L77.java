package bfs;

import java.util.*;

/* Return all possible combinations of k numbers out of 1 ... n
*  1,2,3,4
*  if k = 2
*  12,13,14,23,24,34
*  It is combination -> 34 and 43 are considered the same one
*
*  How is the process looks like?
*  First of, in the queue, it's a empty ArrayList, but the size is still 1
*  ([])     ->     ([1], [2], [3], [4])   ->  ()
*  num is 0            num is 1
*  How does it prevent [1,4] and [4,1]?
*
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
                // If size is 0 just get 0, however if not 0 then get the last element in the list
                // This would prevent [1,4] and [4,1] because 4 + 1 = 5 which is not <= 4
                // This would just add the larger element to the right position
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
