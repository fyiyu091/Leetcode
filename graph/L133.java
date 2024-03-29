package graph;

/* Clone graph */

import java.util.HashMap;
import java.util.Map;

public class L133 {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // Why do we need a HashMap, to just map the curr to its copy
        return dfs(node, new HashMap<>());
    }

    // Would return the copied of the curr node along with all its graph vertex
    private Node dfs(Node curr, Map<Node, Node> visited) {
        if (visited.containsKey(curr)) {
            return visited.get(curr);
        }

        visited.put(curr, new Node(curr.val));
        for (Node next : curr.neighbors) {
            // Adding the copied one
            visited.get(curr).neighbors.add(dfs(next, visited));
        }

        return visited.get(curr);
    }
}
