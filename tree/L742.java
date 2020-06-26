package tree;

/* Find the nearest leaf node to the target k in the tree */
/* Build the graph first, then bfs search for the nearest node */

import java.util.*;

public class L742 {
    public int findClosestLeaf(TreeNode root, int k) {
        if (root == null) {
            throw new IllegalArgumentException();
        }

        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        buildGraph(graph, root, null);
        TreeNode startNode = null;

        for (TreeNode node : graph.keySet()) {
            if (node != null && node.val == k) {
                startNode = node;
                break;
            }
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(startNode);
        visited.add(startNode);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null && graph.get(curr).size() == 1) {
                return curr.val;
            }
            for (TreeNode nei : graph.get(curr)) {
                if (visited.add(nei)) {
                    queue.offer(nei);
                }
            }
        }

        throw new IllegalStateException();
    }

    private void buildGraph(Map<TreeNode, List<TreeNode>> graph, TreeNode curr, TreeNode parent) {
        if (curr == null) {
            return;
        }

        if (!graph.containsKey(curr)) {
            graph.put(curr, new ArrayList<>());
        }
        if (!graph.containsKey(parent)) {
            graph.put(parent, new ArrayList<>());
        }

        graph.get(curr).add(parent);
        graph.get(parent).add(curr);
        buildGraph(graph, curr.left, curr);
        buildGraph(graph, curr.right, curr);
    }
}
