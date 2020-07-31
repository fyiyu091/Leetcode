package graph;

/*
   Check if a graph is bipartite
   Use a color array to representing each vertex's color
   Each vertex's neighbors' color must different from the vertex's color
 */
public class L785 {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return false;
        }

        int n = graph.length;
        Boolean[] colors = new Boolean[n];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == null && !dfs(graph, i, colors, true)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int curr, Boolean[] colors, boolean color) {
        if (colors[curr] != null && colors[curr] != color) {
            return false;
        }
        if (colors[curr] != null && colors[curr] == color) {
            return true;
        }

        colors[curr] = color;
        for (int nei : graph[curr]) {
            if (!dfs(graph, nei, colors, !color)) {
                return false;
            }
        }

        return true;
    }
}
