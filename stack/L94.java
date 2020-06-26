package stack;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* Inorder traversal */

public class L94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode curr = root;
        stack.push(curr);

        while (!stack.isEmpty()) {
            // prev is the parent of curr
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                }
                else if (curr.right != null) {
                    res.add(curr.val);
                    stack.push(curr.right);
                }
                else {
                    res.add(curr.val);
                    stack.pop();
                }
            }
            // prev is left child of curr
            else if (curr.left == prev) {
                res.add(curr.val);
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                else {
                    stack.pop();
                }
            }
            // prev is right child of curr
            else {
                stack.pop();
            }
            prev = curr;
        }
        return res;
    }
}
