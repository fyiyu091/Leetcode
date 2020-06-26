package stack;

/* Convert a string to NestedInteger */

import bfs.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;

public class L385 {
    public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        char[] chars = s.toCharArray();
        Deque<NestedInteger> stack = new ArrayDeque<>();
        int len = chars.length;
        int i = 0;
        int sign = 1;
        int num = 0;
        if (chars[0] != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }

        while (i < len) {
            if (chars[i] == '[') {
                stack.push(new NestedInteger());
            }
            else if (chars[i] == ']' || chars[i] == ',') {
                if (i > 1 && chars[i - 1] == '[') {
                    i++;
                    continue;
                }
                NestedInteger top = stack.pop();
                if (stack.isEmpty()) {
                    stack.push(top);
                }
                else {
                    stack.peek().add(top);
                }
            }
            else if (chars[i] == '-') {
                sign = -1;
            }
            else {
                while (i < len && chars[i] >= '0' && chars[i] <= '9') {
                    num = num * 10 + Character.getNumericValue(chars[i]);
                    i++;
                }
                num *= sign;
                stack.push(new NestedInteger(num));
                num = 0;
                sign = 1;
                continue;
            }
            i++;
        }

        return stack.peek();
    }
}
