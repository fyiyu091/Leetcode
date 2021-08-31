package graph;

import java.util.*;

public class L1136 {
    public int minimumSemesters(int n, int[][] relations) {
        // Idx is the class
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        int[] inDegree = new int[n + 1];
        for (int[] relation : relations) {
            int prev = relation[0];
            int next = relation[1];
            graph.get(prev).add(next);
            inDegree[next]++;
        }


        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int semesters = 0;
        int courses = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            semesters++;
            while (size-- > 0) {
                int curr = queue.poll();
                courses++;
                List<Integer> nexts = graph.get(curr);
                for (int next : nexts) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        return courses == n ? semesters : -1;
    }
}
