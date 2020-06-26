package amazonoa;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostToConnectRopes {
    private int mergeRope(int[] ropes) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int r : ropes) {
            minHeap.offer(r);
        }

        int cost = 0;
        while (minHeap.size() > 1) {
            int r1 = minHeap.poll();
            int r2 = minHeap.poll();
            int sum = r1 + r2;
            cost += sum;
            minHeap.offer(sum);
        }

        return cost;
    }
}
