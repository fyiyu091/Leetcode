package bfs;

import java.util.*;

/* Return all possible combinations of k numbers out of 1 ... n */

public class L77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
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
