package amazonmianjin;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinBetweenKSortedArray {
    public class Cell {
        private int i;
        private int j;
        private int val;
        Cell(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    public int minBetweenKSortedArray(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int res = Integer.MAX_VALUE;
        int max = 0;
        Queue<Cell> minHeap = new PriorityQueue<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                return c1.val - c2.val;
            }
        });

        // The first col are all the smallest in each row
        for (int i = 0; i < row; i++) {
            max = Math.max(max, matrix[i][0]);
            minHeap.offer(new Cell(i, 0, matrix[i][0]));
        }

        while (true) {
            Cell next = minHeap.poll();
            res = Math.min(res, max - next.val);
            if (next.j == col - 1) {
                return res;
            }
            else {
                minHeap.offer(new Cell(next.i, next.j + 1, matrix[next.i][next.j + 1]));
                if (matrix[next.i][next.j + 1] > max) {
                    max = matrix[next.i][next.j + 1];
                }
            }
        }
    }
}
