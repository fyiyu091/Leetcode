package stack;

import java.util.Stack;

/* Calculator II
*  Only have  +, -, *, /
*  */

public class L227 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 0;
        int num = 0;
        char op = '+';

        // stack stores at curr opr, the previous values including -/+
        // always calculate previous values when stop at an operator or the last digit
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + Character.getNumericValue(ch);
            }
            if (ch != ' ' && !Character.isDigit(ch) || i == s.length() - 1) {
                if (op == '+') {
                    stack.push(num);
                }
                else if (op == '-') {
                    stack.push(-num);
                }
                else if (op == '*') {
                    stack.push(stack.pop() * num);
                }
                else if (op == '/') {
                    stack.push(stack.pop() / num);
                }
                else {
                    throw new IllegalArgumentException();
                }
                op = ch;
                num = 0;
            }
        }

        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}
