package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L78 {
    public List<List<Integer>> subsets(int[] nums) {
        // queue stores idx
        Queue<List<Integer>> queue = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return (List) queue;
        }

        queue.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = queue.size();
            while (size-- > 0) {
                List<Integer> curr = queue.poll();
                queue.offer(curr);
                List<Integer> next = new ArrayList<>();
                next.addAll(curr);
                next.add(nums[i]);
                queue.offer(next);
            }
        }

        return (List) queue;
    }
}
