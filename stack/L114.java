package stack;

/* Using stack to flat the binary tree to linked list */

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class L114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                curr.right = curr.left;
                curr.left = null;
            }
            else {
                if (!stack.isEmpty()) {
                    TreeNode top = stack.pop();
                    curr.right = top;
                }
            }
            curr = curr.right;
        }

        return;
    }
}
