package stack;

/* use stack to do binary tree preorder traversal */

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L144 {
    public List<Integer> preorderTraversal(TreeNode root) {
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
                res.add(curr.val);
                if (curr.left != null) {
                    stack.push(curr.left);
                }
                else if (curr.right != null) {
                    stack.push(curr.right);
                }
                else {
                    stack.pop();
                }
            }
            // prev is left child of curr
            else if (curr.left == prev) {
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
