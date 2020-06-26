package graph;

import java.util.ArrayList;
import java.util.List;

public class L1192 {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> connection : connections) {
            graph[connection.get(0)].add(connection.get(1));
            graph[connection.get(1)].add(connection.get(0));
        }

        return res;
    }

//    private int dfs(List<Integer>[] graph, int curr, List<List<Integer>> res, int[] label, Set<Integer> visited) {
//        if (!visited.add(curr)) {
//            return label[0];
//        }
//
//        int ret = Integer.MAX_VALUE;
//        for (int next : graph[curr]) {
//            label[0] + ;
//            ret = Math.min(ret, dfs(graph, next, res, label, visited));
//            if ()
//        }
//    }
}
