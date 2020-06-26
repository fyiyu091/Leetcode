package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/* Zigzag traversal of a binary tree */

public class L103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        boolean flag = false;
        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (!flag) {
                    TreeNode curr = deque.pollLast();
                    level.add(curr.val);
                    if (curr.left != null) {
                        deque.offerFirst(curr.left);
                    }
                    if (curr.right != null) {
                        deque.offerFirst(curr.right);
                    }
                }
                else {
                    TreeNode curr = deque.pollFirst();
                    level.add(curr.val);
                    if (curr.right != null) {
                        deque.offerLast(curr.right);
                    }
                    if (curr.left != null) {
                        deque.offerLast(curr.left);
                    }
                }
            }
            res.add(level);
            flag = !flag;
        }
        return res;
    }
}
