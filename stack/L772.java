package stack;

/*
  Basic calculator III
  +, -, *, (, )
*/

import java.util.*;

public class L772 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        s = '(' + s + ')';
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<Character> optStack = new ArrayDeque<>();
        Map<Character, Integer> optPri = new HashMap<>();
        optPri.put('+', 0);
        optPri.put('-', 0);
        optPri.put('*', 1);
        optPri.put('/', 1);

        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                i++;
            }
            // Need to consider (-5... case
            // Solution is to push 0 into numStack
            else if (ch == '(') {
                optStack.push('(');
                int idx = i + 1;
                while (idx < s.length()) {
                    char idxCh = s.charAt(idx);
                    if (idxCh == ' ') {
                        idx++;
                    }
                    else if (idxCh == '-') {
                        numStack.push(0);
                        break;
                    }
                    else {
                        break;
                    }
                }
                i++;
            }
            else if (ch == '*' || ch == '/' || ch == '+' || ch == '-' || ch == ')') {
                addOpt(ch, numStack, optStack, optPri);
                i++;
            }
            else if (ch >= '0' && ch <= '9') {
                int val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    char tmp = s.charAt(i++);
                    val = val * 10 + (tmp - '0');
                }
                numStack.push(val);
            }
            else {
                throw new IllegalArgumentException();
            }
        }
        return numStack.peek();
    }

    /*
        The very core of this algorithm
        The most tricky part is that we have a operator priority case here
        For example 3 * 5 - 6
        6
        5    -
        3    *
        is not right, instead when we trying to push -, we should calculate * first

        6
        15   -
     */
    private void addOpt(char ch, Deque<Integer> numStack, Deque<Character> optStack, Map<Character, Integer> optPri) {
        if (ch == ')') {
            while (true) {
                char top = optStack.pop();
                if (top == '(') {
                    break;
                }
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                cal(numStack, num1, num2, top);
            }
        }
        else {
            while (true) {
                if (optStack.isEmpty()) {
                    break;
                }
                // when topOpt is ( the topOptPri will be null
                Character topOpt = optStack.peek();
                Integer topOptPri = optPri.get(topOpt);
                if (topOptPri == null || optPri.get(ch) > topOptPri) {
                    break;
                }
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                Character popOpt = optStack.pop();
                cal(numStack, num1, num2, popOpt);
            }
            optStack.push(ch);
        }
    }

    private void cal(Deque<Integer> numStack, int num1, int num2, Character popOpt) {
        switch (popOpt) {
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
