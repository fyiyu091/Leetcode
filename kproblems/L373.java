package kproblems;

/* Find k pairs within two integer arrays that have the smallest sums */

import java.util.*;

public class L373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1 == null || nums2 == null) {
            return res;
        }

        Queue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] + o1[1]) - (o2[0] + o2[1]);
            }
        });

        for (int i = 0; i < nums1.length; i++) {
            minHeap.offer(new int[] {nums1[i], nums2[0], 0}); // Adding the index of nums2 element so that we can move to the next
        }

        while (!minHeap.isEmpty() && k > 0) {
            int[] curr = minHeap.poll();
            res.add(Arrays.asList(curr[0], curr[1]));
            k--;
            if (curr[2] == nums2.length - 1) {
                continue;
            }
            minHeap.offer(new int[] {curr[0], nums2[curr[2] + 1], curr[2] + 1});
        }

        return res;
    }
}
