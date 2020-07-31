package stack;

import java.util.Deque;
import java.util.LinkedList;

/* Sliding window maximum */
public class L239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // corner case
        if(nums == null || nums.length == 0){
            return new int[0];
        }

        // Deque stores the value, not idx
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                update(deque, nums[i]);
                continue;
            }
            // Check to remove the first() first
            if (i >= k && deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }
            update(deque, nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }

        return res;
    }

    private void update(Deque<Integer> deque, int val) {
        while (!deque.isEmpty() && deque.peekLast() < val) {
            deque.pollLast();
        }
        deque.offerLast(val);
    }
}
