package stack;

/* Ternary expression parser
*  T?2:3 being evaluated to 2
*
*  */

import java.util.Stack;

public class L439 {
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) {
            return "";
        }

        Stack<String> stack = new Stack<>();
        int i = expression.length() - 1;
        while (i >= 0) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch) || Character.isAlphabetic(ch)) {
                StringBuilder sb = new StringBuilder();
                while (i >= 0 && Character.isDigit(expression.charAt(i)) || Character.isAlphabetic(expression.charAt(i))) {
                    sb.append(ch);
                    i--;
                }
                stack.push(sb.reverse().toString());
                continue;
            }
            else if (ch == ':') {
                i--;
            }
            else if (ch == '?') {
                String candidateT = stack.pop();
                String candidateF = stack.pop();
                char prevCh = expression.charAt(i - 1);
                if (prevCh == 'T') {
                    stack.push(candidateT);
                }
                else {
                    stack.push(candidateF);
                }
                i -= 2;
            }
        }

        return stack.peek();
    }
}
