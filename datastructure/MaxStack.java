package datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    The two stacks solution
    1. Keep the size of stack and maxStack the same
    2. For popMax, using a helper stack to store all the numbers until find the max in the stack then push back
 */
public class MaxStack {
    private Deque<Integer> stack;
    private Deque<Integer> maxStack;

    public MaxStack() {
        stack = new ArrayDeque<>();
        maxStack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.offerLast(x);
        if (maxStack.isEmpty() || x > maxStack.peekLast()) {
            maxStack.offerLast(x);
        }
        else {
            maxStack.offerLast(maxStack.peekLast());
        }
    }

    public int pop() {
        if (maxStack.isEmpty()) {
            throw new RuntimeException();
        }
        maxStack.pollLast();
        return stack.pollLast();
    }

    public int top() {
        if (maxStack.isEmpty()) {
            throw new RuntimeException();
        }
        return stack.peekLast();
    }

    public int peekMax() {
        if (maxStack.isEmpty()) {
            throw new RuntimeException();
        }
        return maxStack.peekLast();
    }

    public int popMax() {
        if (maxStack.isEmpty()) {
            throw new RuntimeException();
        }
        Deque<Integer> helper = new ArrayDeque<>();
        // POP until we have find the max in stack
        // Then push back
        int res = maxStack.peekLast();
        while (res != top()) {
            helper.offerLast(pop());
        }
        pop();
        while (!helper.isEmpty()) {
            push(helper.pollLast());
        }
        return res;
    }
}
