package stack;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class L1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        TreeNode curr = root;

        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if (node.val < stack.peek().val) {
                stack.peek().left = node;
                stack.push(node);
            }
            else {
                TreeNode tmp = null;
                while (!stack.isEmpty() && stack.peek().val < node.val) {
                    tmp = stack.pop();
                }
                tmp.right = node;
                stack.push(node);
            }
        }

        return root;
    }
}
