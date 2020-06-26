package stack;

/* Validate stack sequences */

import java.util.Stack;

public class L946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length == 0 || popped.length == 0) {
            return true;
        }
        if (pushed.length != popped.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();

        int elementLen = pushed.length;
        int j = 0;

        for (int n : pushed) {
            stack.push(n);

            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return j == elementLen;
    }
}
