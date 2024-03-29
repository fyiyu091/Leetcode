package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheckCycleBFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) {
            return true;
        }

        int count = 0;
        int[] inDegrees = new int[numCourses];
        // Each index is like each vertex, the list of integer on each index is like the neighbors
        List<Integer>[] graph = (LinkedList<Integer>[]) new LinkedList[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph[from].add(to);
            inDegrees[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            // No indegree, then offer into the queue
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            count++;
            int curr = queue.poll();
            for (int nei : graph[curr]) {
                inDegrees[nei]--;
                if (inDegrees[nei] == 0) { // Offer into queue only when the indegree is 0
                    queue.offer(nei);
                }
            }
        }

        return count == numCourses;
    }
}
