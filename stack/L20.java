package stack;

import java.util.Stack;

public class L20 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(': {
                    stack.push('(');
                    break;
                }
                case '{': {
                    stack.push('{');
                    break;
                }
                case '[': {
                    stack.push('[');
                    break;
                }
                case ')': {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                }
                case '}': {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                }
                case ']': {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                }
            }
        }
        return stack.isEmpty();
    }
}
