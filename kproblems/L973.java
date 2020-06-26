package kproblems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class L973 {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0 || points[0] == null || points[0].length == 0) {
            return null;
        }

        Queue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if ((o1[0] * o1[0] + o1[1] * o1[1]) == (o2[0] * o2[0] + o2[1] * o2[1])) {
                    return 0;
                }
                else if ((o1[0] * o1[0] + o1[1] * o1[1]) < (o2[0] * o2[0] + o2[1] * o2[1])) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        });

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[maxHeap.size()][2];
        for (int i = 0; i < K; i++) {
            res[i] = maxHeap.poll();
        }

        return res;
    }
}
