package bfs;

import java.util.*;
/*  Author: Zhengshuang Ren
   Last Modified: 08/08/2018 9:35PM
   Comments & Bugs Report: zhengshuangren@gmail.com
                           Wechat: ZRen
*/
public class NestedInteger {
    private Integer value;
    private List<NestedInteger> list;

    // Constructor initializes an empty nested list.
    public NestedInteger() {
        this.list = new LinkedList<>();
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
        this.value = value;
    }

    // @return true if this bfs.NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return this.value != null;
    }

    // @return the single integer that this bfs.NestedInteger holds, if it holds a single integer
    // Return null if this bfs.NestedInteger holds a nested list
    public Integer getInteger() {
        return this.value;
    }

    // Set this bfs.NestedInteger to hold a single integer.
    public void setInteger(int value) {
        this.value = value;
    }

    // Set this bfs.NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
        // this bfs.NestedInteger currently holds a single integer
        // change it to NestedList and add its previous value
        if (this.isInteger()) {
            this.list = new LinkedList<>();
            this.list.add(this);
            this.value = null;
        }
        // this bfs.NestedInteger currently holds a NestedList
        // add the bfs.NestedInteger to the list
        else {
            this.list.add(ni);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.isInteger()) {
            sb.append(this.value);
            return sb.toString();
        } else {
            sb.append("[");
            int size = this.list.size();
            for (int i = 0; i < size; i++) {
                sb.append(list.get(i).toString());
                if (i != size - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
        }
        return sb.toString();
    }


    // @return the nested list that this bfs.NestedInteger holds, if it holds a nested list
    // Return null if this bfs.NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return this.list;
    }

    // Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
    // Each element is either an integer, or a list -- whose elements may also be integers or other lists.
    public static int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        int sum = 0;
        int level = 1;
        for (NestedInteger ni : nestedList) {
            queue.offer(ni);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                NestedInteger cur = queue.poll();
                if (cur.isInteger()) {
                    sum += level * cur.getInteger();
                } else {
                    for (NestedInteger ni : cur.getList())
                        queue.offer(ni);
                }
            }
            level++;
        }
        return sum;
    }
}