package graph;

/* Number of connected components in an undirected graph */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L323 {
    public int countComponents(int n, int[][] edges) {
        if (n <= 0) {
            return 0;
        }

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                res++;
                dfs(graph, i, visited);
            }
        }

        return res;
    }

    private void dfs(List<Integer>[] graph, int curr, Set<Integer> visited) {
        if (!visited.add(curr)) {
            return;
        }

        for (int next : graph[curr]) {
            dfs(graph, next, visited);
        }
    }
}
