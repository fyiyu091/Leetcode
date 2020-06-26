package dfs;

import java.util.PriorityQueue;
import java.util.Queue;

/* Find the kth largest permutation
   1 2 3
   1 3 2
   2 1 3
   2 3 1
   3 1 2
   3 2 1
 */
public class L60 { //TODO
    public String getPermutation(int n, int k) {
        if (n < 1) {
            return "";
        }

        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        dfs(nums, k, maxHeap, 0);
        return String.valueOf(maxHeap.peek());
    }

    private void dfs(int[] nums, int k, Queue<Integer> maxHeap, int idx) {
        if (idx == nums.length) {
            int num = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                num = num * 10 + nums[i];
            }

            maxHeap.offer(num);
            while (maxHeap.size() > k) {
                maxHeap.poll();
            }

            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            dfs(nums, k, maxHeap, idx + 1);
            swap(nums, i, idx);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
