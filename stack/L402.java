package stack;

/* Remove K digits
   increasing number of stack
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class L402 {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || k >= num.length()) {
            return "0";
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && ch < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        // If the case is like "123456", everything will be in stack
        while (k-- > 0) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            // If the stack contains 0200, we just want to have 200 in sb
            char tmp = stack.pollLast();
            if (sb.length() == 0 && tmp == '0') {
                continue;
            }
            sb.append(tmp);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
