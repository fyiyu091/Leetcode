package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    When we encounter to remove the element basic on the coming element
    think of stack
    1. If peek is + and coming is -, eliminate all the way and if is empty or is negative
 */
public class L735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            }
            else {
                // When to push, when the peek() is smaller
                while (!stack.isEmpty() && stack.peek() > 0) {
                    // peek is 10, asteroid is -5 -> 5
                    if (stack.peek() >= -asteroid) {
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
                if (!stack.isEmpty() && stack.peek() == -asteroid) {
                    stack.pop();
                }
                else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
            }
        }

        int size = stack.size();
        int[] res = new int[size];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}
