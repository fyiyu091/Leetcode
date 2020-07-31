package graph;

import java.util.*;

/*
   Find the longest cycle in a directed graph
   For a cycle, use a label to representing all the cycles
   Mark every vertex with a global label, once cycle back to a labelled vertex
   update it and get max, do this to all vertice
 */
public class LongestCycle {
    private int max = 0;
    public int findLongestCycle(int n, List<List<Integer>> edges){
        //cc
        if (edges == null || edges.size() == 0) return 0;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] ts = new int[n];
        buildGraph(edges, graph);
        dfs(ts, graph, 0, -1, 1);
        return max;
    }
    private int dfs(int[] ts, HashMap<Integer, List<Integer>> graph, int cur, int prev, int t){
        if (ts[cur] > 0 ) return ts[cur];
        //if not touch, update
        ts[cur] = t++;
        int r_tscur = Integer.MAX_VALUE;
        for (Integer next : graph.get(cur)){
            if(next == prev) continue;
            r_tscur = Math.min(dfs(ts, graph, next, cur, t), r_tscur);
        }
        if(r_tscur != 0){
            max = Math.max(max, ts[cur] - r_tscur + 1);
        }
        return Math.min(ts[cur], r_tscur);
    }
    private void buildGraph(List<List<Integer>> edges, HashMap<Integer, List<Integer>> graph){
        for (List<Integer> edge: edges){
            int cur = edge.get(0);
            int next = edge.get(1);
            if (graph.get(cur) == null){
                graph.put(cur, new ArrayList<>());
            }
            if (graph.get(next)== null){
                graph.put(next, new ArrayList<>());
            }
            graph.get(cur).add(next);
            graph.get(next).add(cur);
        }
    }
}
