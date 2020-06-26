package stack;

/* Maximal rectangle
*  [1,0,1,0,0]
*  [1,0,1,1,1]
*  [1,1,1,1,1]
*  [1,0,0,1,0]
*
*  Model this to the histogram problem
*  Each row looking up can be view as a histogram problem
*  * */

import java.util.ArrayDeque;
import java.util.Deque;

public class L85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int res = 0;
        int[] rowArr = new int[col];

        for (int i = 0; i < row; i++) {
            rowArr = buildHistogram(matrix, rowArr, i);
            res = Math.max(res, maxArea(rowArr));
        }

        return res;
    }

    private int maxArea(int[] arr) {
        // Now the problem becomes find the max histogram in arr
        int len = arr.length;
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int j = 0; j <= len; j++) {
            int height = j == len ? -1 : arr[j];
            while (!stack.isEmpty() && height < arr[stack.peek()]) {
                res = Math.max(res, arr[stack.pop()] * (j - (stack.isEmpty() ? -1 : stack.peek()) - 1));
            }
            stack.push(j);
        }

        return res;
    }

    private int[] buildHistogram(char[][] matrix, int[] rowArr, int i) {
        int col = matrix[0].length;
        int[] res = new int[col];
        if (i == 0) {
            for (int j = 0; j < col; j++) {
                res[j] = Character.getNumericValue(matrix[0][j]);
            }
        }
        else {
            for (int j = 0; j < col; j++) {
                res[j] = matrix[i][j] == '1' ? rowArr[j] + 1 : 0;
            }
        }
        return res;
    }
}
