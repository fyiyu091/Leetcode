package graph;

import java.util.*;

/* Return the ordering of courses you should take to finish all course */

public class L210 {
    enum Status {
        UNCHECK,
        VISITING,
        VISITED;
    }

    class Node {
        int val;
        Status status;
        List<Integer> neis;
        Node(int val) {
            this.val = val;
            this.status = Status.UNCHECK;
            this.neis = new ArrayList<>();
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }

        Node[] graph = new Node[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new Node(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph[from].neis.add(to);
        }

        List<Integer> list = new LinkedList<>();

        for (Node node : graph) {
            if (dfs(node, graph, list)) {
                return new int[0];
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private boolean dfs(Node curr, Node[] graph, List<Integer> list) {
        if (curr.status == Status.VISITING) {
            return true;
        }
        if (curr.status == Status.VISITED) {
            return false;
        }

        curr.status = Status.VISITING;
        for (int nei : curr.neis) {
            Node neiNode = graph[nei];
            if (dfs(neiNode, graph, list)) {
                return true;
            }
        }

        list.add(0, curr.val);
        curr.status = Status.VISITED;
        return false;
    }
}
