package stack;

import bfs.NestedInteger;

import java.util.*;


public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> st;
    public NestedIterator(List<NestedInteger> nestedList) {
        st = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            st.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        while (!st.isEmpty() && !st.peek().isInteger()) {
            List<NestedInteger> list = st.pop().getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                st.push(list.get(i));
            }
        }
        return st.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!st.isEmpty() && !st.peek().isInteger()) {
            List<NestedInteger> list = st.pop().getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                st.push(list.get(i));
            }
        }
        return !st.isEmpty();
    }
}
