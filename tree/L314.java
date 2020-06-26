package tree;

/* Vertical order traversal */

import java.util.*;

public class L314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        // set min and max to be 0 instead of MAX_VALUE and MIN_VALUE
        int max = 0;
        int min = 0;

        nodeQ.offer(root);
        colQ.offer(0);

        while (!colQ.isEmpty()) {
            TreeNode currNode = nodeQ.poll();
            int currCol = colQ.poll();

            map.putIfAbsent(currCol, new ArrayList<>());
            map.get(currCol).add(currNode.val);

            if (currNode.left != null) {
                nodeQ.offer(currNode.left);
                colQ.offer(currCol - 1);
                min = Math.min(min, currCol - 1);
            }
            if (currNode.right != null) {
                nodeQ.offer(currNode.right);
                colQ.offer(currCol + 1);
                max = Math.max(max, currCol + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            res.add(new ArrayList<>(map.get(i)));
        }

        return res;
    }
}
