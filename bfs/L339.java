package bfs;

import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface bfs.NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public bfs.NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public bfs.NestedInteger(int value);
 *
 *     // @return true if this bfs.NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this bfs.NestedInteger holds, if it holds a single integer
 *     // Return null if this bfs.NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this bfs.NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this bfs.NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(bfs.NestedInteger ni);
 *
 *     // @return the nested list that this bfs.NestedInteger holds, if it holds a nested list
 *     // Return null if this bfs.NestedInteger holds a single integer
 *     public List<bfs.NestedInteger> getList();
 * }
 */
public class L339 {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;

        Queue<NestedInteger> queue = new LinkedList<>();
        for (NestedInteger ni : nestedList) {
            queue.offer(ni);
        }

        int res = 0;
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            while (size-- > 0) {
                NestedInteger curr = queue.poll();
                if (curr.isInteger()) {
                    levelSum += curr.getInteger();
                }
                else {
                    for (NestedInteger ni : curr.getList()) {
                        queue.offer(ni);
                    }
                }
            }
            res += levelSum * (depth++);
        }

        return res;
    }
}
