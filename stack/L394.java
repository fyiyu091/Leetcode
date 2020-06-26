package stack;

/* Decode string
*  3[a]2[bc] to aaabcbc
* */

import java.util.Stack;

public class L394 {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        int i = 0;
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        strStack.push(new StringBuilder());
        int len = s.length();

        while (i < len) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int num = 0;
                while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + Character.getNumericValue(s.charAt(i));
                    i++;
                }
                numStack.push(num);
                continue;
            }
            else if (ch == '[') {
                strStack.push(new StringBuilder());
            }
            else if (Character.isAlphabetic(ch)) {
                strStack.peek().append(ch);
            }
            else if (ch == ']') {
                int count = numStack.pop();
                StringBuilder top = strStack.pop();
                while (count-- > 0) {
                    strStack.peek().append(top);
                }
            }
            else {
                throw new IllegalArgumentException();
            }
            i++;
        }

        return strStack.peek().toString();
    }
}
