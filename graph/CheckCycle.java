package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CheckCycle {
    public List<Integer> checkCycle(Map<Vertex, List<Vertex>> graph) {
        List<Integer> res = new LinkedList<>();
        if (graph == null) {
            return res;
        }

        // Use a map to mark the three different status of the vertex
        Map<Vertex, Integer> status = new HashMap<>();
        for (Vertex curr : graph.keySet()) {
            status.put(curr, 0);
        }

        for (Vertex curr : graph.keySet()) {
            dfs(curr, graph, status, res);
        }
        return res;
    }

    private boolean dfs(Vertex curr, Map<Vertex, List<Vertex>> graph, Map<Vertex, Integer> status, List<Integer> res) {
        if (status.get(curr) == 1) {
            throw new IllegalStateException("the graph has cycle");
        }
        if (status.get(curr) == 2) {
            return false;
        }

        status.put(curr, 1);
        for (Vertex nei : graph.get(curr)) {
            dfs(nei, graph, status, res);
        }

        res.add(0, curr.val);
        status.put(curr, 2);
        return false;
    }
}
