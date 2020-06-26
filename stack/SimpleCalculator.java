package stack;

/* Assume the calculator only have 3+1*3*3, no space or parentheses and always valid */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SimpleCalculator {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> oprPri = new HashMap<>();
        oprPri.put('+', 0);
        oprPri.put('-', 0);
        oprPri.put('*', 1);

        Stack<Integer> numStack = new Stack<>();
        Stack<Character> oprStack = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int val = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    val = val * 10 + (s.charAt(i++) - '0');
                }
                numStack.push(val);
            }
            else {
                cal(numStack, oprStack, ch, oprPri);
                oprStack.push(ch);
                i++;
            }
        }
        while (!oprStack.isEmpty()) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            Character popOpr = oprStack.pop();
            eval(numStack, num1, num2, popOpr);
        }

        return numStack.peek();
    }

    private void cal(Stack<Integer> numStack, Stack<Character> oprStack, char ch, Map<Character, Integer> oprPri) {
        while (true) {
            if (oprStack.isEmpty()) {
                break;
            }
            char topOpr = oprStack.peek();
            Integer topOprPri = oprPri.get(topOpr);
            if (topOprPri == null || topOprPri < oprPri.get(ch)) {
                break;
            }
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            Character popOpr = oprStack.pop();
            eval(numStack, num1, num2, popOpr);
        }
    }

    private void eval(Stack<Integer> numStack, int num1, int num2, Character popOpr) {
        switch (popOpr) {
            case '+':
                numStack.push(num2 + num1);
                return;
            case '-':
                numStack.push(num2 - num1);
                return;
            case '*':
                numStack.push(num2 * num1);
                return;
            case '/':
                numStack.push(num2 / num1);
                return;
            default:
                throw new IllegalArgumentException();
        }
    }
}
