package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    Return how many days you would have to wait until a warmer temperature
 */
public class L739 {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return new int[0];
        }

        int len = T.length;
        int[] res = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int day = stack.pop();
                res[day] = i - day;
            }
            stack.push(i);
        }

        return res;
    }
}
