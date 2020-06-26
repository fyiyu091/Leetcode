package bfs;

/* Trapping rain water II */

import java.util.*;

public class L407 {
    private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    class Cell {
        int i;
        int j;
        int val;
        Cell(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0] == null || heightMap[0].length == 0) {
            return 0;
        }

        Comparator<Cell> comp = new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.val - o2.val;
            }
        };

        Queue<Cell> maxHeap = new PriorityQueue<>(comp);
        int row = heightMap.length;
        int col = heightMap[0].length;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < row; i++) {
            maxHeap.offer(new Cell(i, 0, heightMap[i][0]));
            maxHeap.offer(new Cell(i, col - 1, heightMap[i][col - 1]));
            visited.add(i * col);
            visited.add(i * col + col - 1);
        }
        for (int j = 1; j < col - 1; j++) {
            maxHeap.offer(new Cell(0, j, heightMap[0][j]));
            maxHeap.offer(new Cell(row - 1, j, heightMap[row - 1][j]));
            visited.add(j);
            visited.add((row - 1) * col + j);
        }

        int res = 0;
        while (!maxHeap.isEmpty()) {
            Cell curr = maxHeap.poll();
            for (int[] dir : DIRECTIONS) {
                int ii = curr.i + dir[0];
                int jj = curr.j + dir[1];
                if (ii >= 0 && ii < row && jj >= 0 && jj < col && visited.add(ii * col + jj)) {
                    if (heightMap[ii][jj] < curr.val) {
                        res += curr.val - heightMap[ii][jj];
                        maxHeap.offer(new Cell(ii, jj, curr.val));
                    }
                    else {
                        maxHeap.offer(new Cell(ii, jj, heightMap[ii][jj]));
                    }
                }
            }
        }

        return res;
    }
}
