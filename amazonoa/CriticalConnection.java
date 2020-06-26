package amazonoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnection {
    class Node {
        int val;
        int label;
        List<Integer> neighbor;
        public Node(int val) {
            this.val = val;
            this.label = 0;
            this.neighbor = new ArrayList<>();
        }
    }
    private static int mark = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        Node[] graph = new Node[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new Node(i);
        }
        buildGraph(graph, connections);
        boolean[] visited = new boolean[n];
        dfs(graph, 0, -1, res, visited);
        return res;
    }

    private void buildGraph(Node[] graph, List<List<Integer>> connections) {
        for (List<Integer> connection : connections) {
            int from = connection.get(0);
            int to = connection.get(1);
            graph[from].neighbor.add(to);
            graph[to].neighbor.add(from);
        }
        return;
    }

    private void dfs(Node[] graph, int curr, int prev, List<List<Integer>> res, boolean[] visited) {
        visited[curr] = true;
        graph[curr].label = mark++;
        int currMark = graph[curr].label;
        for (int nei : graph[curr].neighbor) {
            if (nei == prev) {
                continue;
            }
            if (!visited[nei]) {
                dfs(graph, nei, curr, res, visited);
            }
            // If we want to calculate the largest circle in the graph
            // We can representing all the element in the graph by the smallest
            // Calculate Math.max(largest - currMark)
            graph[curr].label = Math.min(graph[curr].label, graph[nei].label);
            if (graph[nei].label > currMark) {
                res.add(Arrays.asList(nei, curr));
            }
        }
        return;
    }
}
