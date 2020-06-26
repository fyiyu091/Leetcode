package stack;

/* Verify preorder sequence in BST */

import java.util.ArrayDeque;
import java.util.Deque;

public class L255 {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return true;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        Integer lowBound = null;
        for (int n : preorder) {
            if (lowBound != null && n < lowBound) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() < n) {
                lowBound = stack.pop();
            }
            stack.push(n);
        }

        return true;
    }
}
