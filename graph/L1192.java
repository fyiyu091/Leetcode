package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
   The key is if the return label is equal or larger than the current label
   Prev to curr is a critial edge

   0 - 1 - 2 - 3 - 4
           |       |
           - - - - -

   This case [0,1] and [1,2] are critical connections
 */
public class L1192 {
    private int label = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        List<Integer>[] graph = new LinkedList[n];
        buildGraph(graph, connections);
        int[] labels = new int[n];
        dfs(graph, -1, 0, labels, res);
        return res;
    }

    private int dfs(List<Integer>[] graph, int prev, int curr, int[] labels, List<List<Integer>> res) {
        if (labels[curr] != 0) {
            return labels[curr];
        }

        int retLabel = Integer.MAX_VALUE;
        labels[curr] = label++;
        for (int nei : graph[curr]) {
            if (nei == prev) {
                continue;
            }
            retLabel = Math.min(retLabel, dfs(graph, curr, nei, labels, res));
        }
        // Before update, need to check the return value
        if (retLabel >= labels[curr]) {
            if (prev != -1) {
                res.add(Arrays.asList(prev, curr));
            }
        }

        return Math.min(labels[curr], retLabel); // Need to return min including its self
    }

    private void buildGraph(List<Integer>[] graph, List<List<Integer>> connections) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        for (List<Integer> connection : connections) {
            int from = connection.get(0);
            int to = connection.get(1);
            graph[from].add(to);
            graph[to].add(from);
        }
    }
}
