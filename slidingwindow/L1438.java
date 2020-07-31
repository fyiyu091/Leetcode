package slidingwindow;

import java.util.PriorityQueue;
import java.util.Queue;

/*
    Find the size of the longest non-empty subarray such that the absolute difference
    between any two elements of this subarray is less than or equal to limit
    Keep a min and max within the window
 */
public class L1438 {
    public int longestSubarray(int[] nums, int limit) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        Queue<Integer> minHeap = new PriorityQueue<>();
        int start = 0;
        int len = nums.length;
        int res = 0;
        for (int end = 0; end < len; end++) {
            int num = nums[end];
            maxHeap.offer(num);
            minHeap.offer(num);
            while (maxHeap.peek() - minHeap.peek() > limit) {
                int remove = nums[start++];
                maxHeap.remove(remove);
                minHeap.remove(remove);
            }
            res = Math.max(res, end - start + 1);
        }

        return res;
    }
}
