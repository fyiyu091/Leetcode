package graph;

/*
   Given number of vertex n, number of edges m, undirected edges
   Check whether we can start at 1 and end at 1, every edge can only
   be used once
 */

// Starting from 1, delete the edges as it goes
// Keep degree array for each vertex, while (degree[curr] > 0)

import java.util.*;

public class StartEndAtSamePoint {
    public boolean startEndAtSamePoint(int n, int[][] edges) {
        // corner case
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        // build the undirected graph
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }


        while (graph.get(1).size() > 0) {
            Integer next = graph.get(1).get(0);
            graph.get(1).remove(0);
            graph.get(next).remove((Integer) 1);
            if (dfs(next, graph)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfs(Integer curr, Map<Integer, List<Integer>> graph) {
        if (curr == 1) {
            return true;
        }

        while (graph.get(curr).size() > 0) {
            Integer next = graph.get(curr).get(0);
            graph.get(curr).remove(0);
            graph.get(next).remove((Integer) curr);
            if (dfs(next, graph)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        StartEndAtSamePoint test = new StartEndAtSamePoint();
        System.out.println(test.startEndAtSamePoint(6, new int[][] {{1,2}, {2,3}, {3,4}, {4,5}, {5,2}, {1,6}, {6,2}}));
        System.out.println(test.startEndAtSamePoint(4, new int[][] {{1,2}, {2,3}, {2,4}, {4,1}}));
        System.out.println(test.startEndAtSamePoint(5, new int[][] {{1,2}, {2,3}, {1,4}, {4,5}}));
    }
}
