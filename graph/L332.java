package graph;

/*Reconstruct itinerary
* 一笔画问题
* 有路就走，because we need to sort by the alphabetical order, so use PriorityQueue
* */

import java.util.*;

public class L332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        if (tickets == null || tickets.size() == 0) {
            return res;
        }

        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        buildGraph(graph, tickets);
        dfs("JFK", graph, res);
        return res;
    }

    private void buildGraph(Map<String, PriorityQueue<String>> graph, List<List<String>> tickets) {
        for (List<String> list : tickets) {
            if (graph.get(list.get(0)) == null) {
                graph.put(list.get(0), new PriorityQueue<>());
            }
            graph.get(list.get(0)).offer(list.get(1));
        }
    }

    private void dfs(String curr, Map<String, PriorityQueue<String>> graph, List<String> res) {
        PriorityQueue<String> next = graph.get(curr);
        while (next != null && !next.isEmpty()) {
            String str = next.poll();
            dfs(str, graph, res);
        }
        res.add(0, curr);
    }
}
