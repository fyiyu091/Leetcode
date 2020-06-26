package stack;

import java.util.Stack;

/* calculator I
 *  +, -, (, ), no * or /
* */

public class L224 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        // store both sign and final res
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int sign = 1;

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int num = Character.getNumericValue(ch);
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    num = num * 10 + Character.getNumericValue(s.charAt(i));
                }
                res += num * sign;
            }
            else if (ch == '+') {
                sign = 1;
            }
            else if (ch == '-') {
                sign = -1;
            }
            // Store the sign and value onto stack, wait for pop to use
            else if (ch == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }
            // use the res within the curr () * the prev sign and add prev res
            else if (ch == ')') {
                res = res * stack.pop() + stack.pop();
            }
            else if (ch == ' ') {
                continue;
            }
            else {
                throw new IllegalArgumentException();
            }
        }
        return res;
    }
}
