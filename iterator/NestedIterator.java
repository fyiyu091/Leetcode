package iterator;

import bfs.NestedInteger;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    private Deque<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new ArrayDeque();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return stack.pop().getInteger();
        }
        else {
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean hasNext() {
        makeStackTopInteger();
        return !stack.isEmpty();
    }

    // This method will make the stack empty, if we have [[]] case
    private void makeStackTopInteger() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            NestedInteger ni = stack.pop();
            for (int i = ni.getList().size() - 1; i >= 0; i--) {
                stack.push(ni.getList().get(i));
            }
        }
    }
}
