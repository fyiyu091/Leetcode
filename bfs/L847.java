package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
    Find the shortest path visiting all nodes
    One thing that this question has a good value is that I can't just think that we should just use visited
    to make sure we don't visit the node twice, in this problem, we can visit the nodes or the edges how many times we want

    The good solution to solve this is to add one dimension to the visited check
    Two dimension:
        1. curr node
        2. visited path, representing by the bit

    1  --  2

       When we are at 1 -> (1, 1)
       Goes to 2 -> (2, 1,2)
       At this point we can still go back to one -> (1, 1,2)
       Still go to 2 -> (2, 1,2) no!!!!!!!!! We can't do it as it already has visited
 */
public class L847 {
    public int shortestPathLength(int[][] graph) {
        // Starting at all points
        Queue<MyPath> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < graph.length; i++) {
            MyPath path = new MyPath(i, (1 << i));
            visited.add(path.convertToString());
            q.offer(path);
        }

        int length = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                MyPath next = q.poll();
                int curr = next.curr;
                int currPath = next.nodes;
                // Assume we have two nodes -> n = 2
                // 1 << 2 -> 100
                // 100 - 1 -> 011 which means both nodes are visited
                if (currPath == (1 << graph.length) - 1) {
                    return length;
                }
                for (int neighbors : graph[curr]) {
                    MyPath newPath = new MyPath(neighbors, currPath | (1 << neighbors));
                    String pathString = newPath.convertToString();
                    if (visited.add(pathString)) {
                        q.offer(newPath);
                    }
                }
            }
            length++;
        }

        return -1;
    }

    class MyPath {
        int curr;
        int nodes;

        MyPath(int curr, int nodes) {
            this.curr = curr;
            this.nodes = nodes;
        }

        String convertToString() {
            return curr + "," + nodes;
        }
    }
}
