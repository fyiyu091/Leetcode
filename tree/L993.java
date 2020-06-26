package tree;

/* Cousins in binary tree */

import java.util.LinkedList;
import java.util.Queue;

public class L993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        if (root.val == x || root.val == y) {
            return false;
        }

        Integer xParent = null;
        Integer yParent = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                    if (curr.left.val == x) {
                        xParent = curr.val;
                    }
                    if (curr.left.val == y) {
                        yParent = curr.val;
                    }
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                    if (curr.right.val == x) {
                        xParent = curr.val;
                    }
                    if (curr.right.val == y) {
                        yParent = curr.val;
                    }
                }
            }
            if (xParent != null && yParent != null && xParent != yParent) {
                return true;
            }

            xParent = null;
            yParent = null;
        }
        return false;
    }
}
