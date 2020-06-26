package stack;

/* Remove all adjacent duplicates in String II
*  remove k adjacent and equal letters
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class L1209 {
    class Pair {
        private int count;
        private char ch;
        Pair(int count, char ch) {
            this.count = count;
            this.ch = ch;
        }
    }

    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Deque<Pair> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || s.charAt(i) != stack.peek().ch) {
                stack.push(new Pair(1, s.charAt(i)));
            }
            else {
                if (stack.peek().count == k - 1) {
                    stack.pop();
                }
                else {
                    stack.peek().count++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            int i = pair.count;
            while (i-- > 0) {
                sb.append(pair.ch);
            }
        }

        return sb.reverse().toString();
    }
}
