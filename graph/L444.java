package graph;

import java.util.*;

/*
    Basically, check whether given the vertex relationship, only has one topological sort and the sort is matching
    with org
    How to check whether the graph has only one topological sort?
    BFS approach, queue can only have one element

    For DFS approach, topologically sorted nodes should have total ordering, i.e. every node in the sorted list should be
    connected to subsequent node
 */
public class L444 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (org == null || org.length == 0) {
            return false;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                graph.put(seq.get(i), new ArrayList<>());
                inDegree.put(seq.get(i), 0);
            }
        }

        buildGraph(graph, seqs, inDegree);
        if (inDegree.keySet().size() != org.length) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int v : inDegree.keySet()) {
            if (inDegree.get(v) == 0) {
                queue.offer(v);
                res.add(v);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size != 1) {
                return false;
            }
            int curr = queue.poll();
            for (int next : graph.get(curr)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    queue.offer(next);
                    res.add(next);
                }
            }
        }

        int i = 0;
        for (int num : res) {
            if (i < org.length && num != org[i]) {
                return false;
            }
            i++;
        }

        return i == org.length;
    }

    private void buildGraph(Map<Integer, List<Integer>> graph, List<List<Integer>> seqs, Map<Integer, Integer> inDegree) {
        for (int i = 0; i < seqs.size(); i++) {
            for (int j = 0; j < seqs.get(i).size() - 1; j++) {
                int from = seqs.get(i).get(j);
                int to = seqs.get(i).get(j + 1);
                graph.get(from).add(to);
                inDegree.put(to, inDegree.get(to) + 1);
            }
        }
    }
}
