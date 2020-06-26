package bst;

import java.util.*;

/* Find the k values in the BST that are closest to the target */

public class L272 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        if (root == null) throw new IllegalArgumentException();

        List<Integer> res = new ArrayList<>();
        Queue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                double diff1 = Math.abs(n1 - target);
                double diff2 = Math.abs(n2 - target);
                if (diff1 > diff2) {
                    return 1;
                }
                else if (diff1 < diff2) {
                    return -1; //-1 means n1 is in the front
                }
                else {
                    return 0;
                }
            }
        });

        TreeNode curr = root;
        dfs(curr, pq);

        while (k-- > 0) {
            res.add(pq.poll());
        }
        return res;
    }

    private void dfs(TreeNode root, Queue<Integer> maxHeap) {
        if (root == null) {
            return;
        }
        maxHeap.offer(root.val);
        dfs(root.left, maxHeap);
        dfs(root.right, maxHeap);
        return;
    }
}
