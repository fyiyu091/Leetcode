package graph;

import java.util.*;

public class L310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1){
            return Arrays.asList(0);
        }

        List<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        int[] degrees = new int[n];
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 1) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                int val = queue.poll();
                for (int nei : graph[val]) {
                    degrees[nei]--;
                    if (degrees[nei] == 1) {
                        queue.offer(nei);
                    }
                }
                level.add(val);
            }
            res = level;
        }

        return res;
    }
}
