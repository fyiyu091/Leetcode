package stack;

/* Largest rectangle in histogram
   Using non-descending stack, stack stores index!!!
 */

import java.util.Stack;

public class L84 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int len = heights.length;
        int res = 0;

        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (i <= len) {
            int height = i == len ? -1 : heights[i];
            while (!stack.isEmpty() && height < heights[stack.peek()]) {
                res = Math.max(res, heights[stack.pop()] * (i - (stack.isEmpty() ? -1 : stack.peek()) - 1));
            }
            stack.push(i++);
        }

        return res;
    }
}
