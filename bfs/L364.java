package bfs;

/* Nested list weight sum II, the weight is defined from bottom up, leaf level has weight 1 */
/* At the end of each level, res have to add this levelSum and all the levelSoFar sum */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L364 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;

        Queue<NestedInteger> queue = new LinkedList<>();

        for (NestedInteger ni : nestedList) {
            queue.offer(ni);
        }

        int res = 0;
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                NestedInteger curr = queue.poll();
                if (curr.isInteger()) {
                    sum += curr.getInteger();
                }
                else {
                    for (NestedInteger ni : curr.getList()) {
                        queue.offer(ni);
                    }
                }
            }
            res += sum;
        }
        return res;
    }
}
