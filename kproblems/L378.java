package kproblems;

import java.util.*;

/*
    2D matrix K smallest
 */
public class L378 {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        Queue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]];
            }
        });
        Set<Integer> set = new HashSet<>();
        set.add(0);
        minHeap.offer(new int[] {0,0});

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < k - 1; i++) {
            int[] curr = minHeap.poll();
            int x = curr[0];
            int y = curr[1];
            if (x + 1 < row && set.add((x + 1) * col + y)) {
                minHeap.offer(new int[] {x + 1, y});
            }
            if (y + 1 < col && set.add(x * col + y + 1)) {
                minHeap.offer(new int[] {x, y + 1});
            }
        }

        int[] res = minHeap.poll();
        int resX = res[0];
        int resY = res[1];
        return matrix[resX][resY];
    }
}
