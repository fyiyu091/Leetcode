package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class L207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }

        boolean hasCycle = false;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> status = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new LinkedList<>());
            status.put(i, 0);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph.get(from).add(to);
        }

        for (int vertex : graph.keySet()) {
            if (dfs(vertex, graph, status)) {
                hasCycle = true;
            }
        }

        return !hasCycle;
    }

    private boolean dfs(int curr, Map<Integer, List<Integer>> graph, Map<Integer, Integer> status) {
        if (status.get(curr) == 1) {
            return true;
        }
        if (status.get(curr) == 2) {
            return false;
        }

        status.put(curr, 1);
        for (int nei : graph.get(curr)) {
            if (dfs(nei, graph, status)) {
                return true;
            }
        }

        status.put(curr, 2);
        return false;
    }
}
