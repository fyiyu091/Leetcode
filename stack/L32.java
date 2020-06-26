package stack;

import java.util.Stack;

/*  Longest valid parentheses
    stack bottom keeps a left limit of the valid parentheses
    E.g. ))) ... case
    seeing ), always pop to redefine the left boundary of the valid parentheses
 */

public class L32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // stack to store the index
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;

        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            }
            else if (ch == ')') {
                int idx = stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                else {
                    res = Math.max(res, i - stack.peek());
                }
            }
            i++;
        }

        return res;
    }
}
