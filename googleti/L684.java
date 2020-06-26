package googleti;

/* Redundant connection */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class L684 {
    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length <= 2) {
            return new int[0];
        }

        int N = edges.length;
        int[] res = new int[2];

        // Build the graph, we have N nodes
        List<Integer>[] graph = new LinkedList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        for (int i = 0; i < edges.length; i++) {
            if (dfs(graph, edges[i][0], edges[i][1], new HashSet<>(), 0)) {
                res[0] = edges[i][0];
                res[1] = edges[i][1];
            }
        }

        return res;
    }

    private boolean dfs(List<Integer>[] graph, int curr, int target, Set<Integer> visited, int count) {
        if (curr == target && count == 1) {
            return false;
        }
        if (!visited.add(curr)) {
            return false;
        }
        if (curr == target && count > 1) {
            return true;
        }

        for (int next : graph[curr]) {
            if (dfs(graph, next, target, visited, count + 1)) {
                return true;
            }
        }

        return false;
    }
}
