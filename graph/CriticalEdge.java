package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CriticalEdge {
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

    private void dfs(List<Integer>[] graph, int prev, int curr, int[] labels, List<List<Integer>> res) {
        if (labels[curr] != 0) {
            return;
        }

        labels[curr] = label++;
        int firstTimeLabel = labels[curr];
        for (int nei : graph[curr]) {
            if (nei == prev) {
                continue;
            }
            dfs(graph, curr, nei, labels, res);
            labels[curr] = Math.min(labels[curr], labels[nei]);
            if (labels[nei] > firstTimeLabel) { // At this point labels[nei] is updated with the smallest value
                res.add(Arrays.asList(curr, nei));
            }
        }
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
