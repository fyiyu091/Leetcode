package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class L777 {
    class Cell {
        private char ch;
        private int idx;
        Cell(char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        }
    }

    public boolean canTransform(String start, String end) {
        if (start == null || end == null) {
            return false;
        }

        int lenS = start.length();
        int lenE = end.length();
        if (lenS != lenE) {
            return false;
        }

        Deque<Cell> stack = new ArrayDeque<>();
        for (int i = 0; i < lenS; i++) {
            char ch = start.charAt(i);
            if (ch != 'X') {
                stack.push(new Cell(ch, i));
            }
        }
        for (int i = lenE - 1; i >= 0; i--) {
            char ch = end.charAt(i);
            if (ch != 'X') {
                if (!stack.isEmpty()) {
                    Cell popCh = stack.pop();
                    if (ch != popCh.ch || (ch == 'R' && i < popCh.idx) || (ch == 'L' && i > popCh.idx)) {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
