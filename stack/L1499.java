package stack;

import java.util.PriorityQueue;

/*
      The equation is yi + yj + |xi - xj| and |xi - xj| <= k
      Which can translate to yi + yj - (xj - xi) -> yi + yj - xj + xi -> yj - xj + (yi + xi)

      So for a point, looking back at its previous points:
         1. Find the largest yj - xj
         2. xj - xi needs to be <= k

      So we can have a PQ, to prioritize over y - x and if equals prioritize smaller x
      Scan from left to right, if xj - xi is > k, so need to keep it in the queue anymore

      How can this translate to a monotonic stack?
      The priority queue holds two condition:
      1. prioritize y - x
      2. prioritize smaller x
      These two condition can easily be hold by using a Deque

      Want to find the maximum value of such equal

      S1: For each coordinates, try it and the complexity would be O(n^2)
      For logn, heap, binary search, BST,
      Something that we can do to not try every possible solutions?
      To use a PQ, what's the priority of the queue
      Saying I get one coordinate out,
 */
public class L1499 {
    private class Pair {
        int key;
        int value;
        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public int findMaxValueOfEquation(int[][] points, int k) {
        // Corner case

        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> a.key == b.key ? a.value - b.value : b.key - a.key);
        int res = Integer.MIN_VALUE;
        for (int[] point : points) {
            while (!heap.isEmpty() && point[0] - heap.peek().value > k) {
                    heap.poll();
            }
            if (!heap.isEmpty()) {
                res = Math.max(res, heap.peek().key + point[0] + point[1]);
            }
            heap.offer(new Pair(point[1] - point[0], point[0]));
        }

        return res;
    }
}
