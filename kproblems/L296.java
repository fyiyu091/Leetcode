package kproblems;

/* Best meeting point */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L296 {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        return getSum(rows) + getSum(cols);
    }

    private int getSum(List<Integer> list) {
        Collections.sort(list);
        int size = list.size();
        int mid = list.get(size / 2);
        int sum = 0;
        for (int n : list) {
            sum += Math.abs(n - mid);
        }

        return sum;
    }
}
